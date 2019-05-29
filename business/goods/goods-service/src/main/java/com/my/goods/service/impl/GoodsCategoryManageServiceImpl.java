package com.my.goods.service.impl;

import com.my.goods.constants.GoodsCategoryConstants;
import com.my.goods.domain.dto.GoodsCategoryAddDto;
import com.my.goods.domain.entity.GoodsCategory;
import com.my.goods.domain.vo.GoodsCategoryAddVo;
import com.my.goods.domain.vo.GoodsCategoryRo;
import com.my.goods.domain.vo.GoodsCategoryUpdateVo;
import com.my.goods.repo.GoodsCategoryMapper;
import com.my.goods.service.GoodsCategoryManageService;
import com.my.goods.utils.GoodsCategoryUtils;
import com.my.include.common.constants.enums.LeafEnum;
import com.my.include.common.constants.enums.ResultEnum;
import com.my.include.common.constants.enums.StatusEnum;
import com.my.include.common.exception.BusinessException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:06
 */
@Service
@Slf4j
@Log4j
public class GoodsCategoryManageServiceImpl implements GoodsCategoryManageService {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategoryRo> selectOneByParentId(int parentId) {
        List<GoodsCategory> list = goodsCategoryMapper.selectByParentId(parentId);
        if (!CollectionUtils.isEmpty(list)) {
            return list.stream().map(this::eoToVo).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<GoodsCategoryRo> selectAllByParentId(int parentId) {
        List<GoodsCategoryRo> result = selectOneByParentId(parentId);
        if (!CollectionUtils.isEmpty(result)) {
            result.forEach(parent -> {
                if (!parent.getIsLeaf()) {
                    parent.setChilds(selectAllByParentId(parent.getCategoryId()));
                }
            });
        }
        return result;
    }

    @Override
    public GoodsCategoryRo selectOneById(int categoryId) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByCategoryId(categoryId);
        return eoToVo(goodsCategory);
    }

    @Override
    public GoodsCategoryRo selectAllById(int categoryId) {
        GoodsCategoryRo result = selectOneById(categoryId);
        if (result != null && !result.getIsLeaf()) {
            result.setChilds(selectAllByParentId(result.getCategoryId()));
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByCategoryId(int categoryId) {
        GoodsCategoryRo result = selectAllById(categoryId);
        if (result != null) {
            goodsCategoryMapper.updateStatusByCategoryId(StatusEnum.UN_VALID.code, categoryId);
            List<Integer> parentIds = new ArrayList<>();
            getParentIds(result, parentIds);
            if (!parentIds.isEmpty()) {
                goodsCategoryMapper.updateStatusByParentIds(StatusEnum.UN_VALID.code, parentIds);
            }
        }
    }

    private void getParentIds(GoodsCategoryRo ro, List<Integer> list) {
        List<GoodsCategoryRo> childs = ro.getChilds();
        if (!CollectionUtils.isEmpty(childs)) {
            list.add(ro.getCategoryId());
            childs.forEach(child -> getParentIds(child, list));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCategory(List<GoodsCategoryAddVo> addVos) {
        if (CollectionUtils.isEmpty(addVos)) {
            throw new BusinessException(ResultEnum.REQ_PARAM_NULL);
        }
        Map<Integer, GoodsCategoryAddDto> map = new HashMap<>();
        addVos.forEach(addVo -> handleAddVO(addVo, map));
    }

    private void handleAddVO(GoodsCategoryAddVo addVo, Map<Integer, GoodsCategoryAddDto> map) {
        GoodsCategoryAddDto dto = map.get(addVo.getParentId());
        int parentId = addVo.getParentId();
        boolean needUpdateParent = false;
        if (dto == null) {
            GoodsCategory parent = findByCategoryId(parentId);
            if (parent == null) {
                log.error(ResultEnum.GOODS_ADD_CATEGORY_1 + " 入参 {}", addVo);
                throw new BusinessException(ResultEnum.GOODS_ADD_CATEGORY_1);
            }
            dto = new GoodsCategoryAddDto();
            dto.setGoodsCategory(parent);
            int orderValue = 1;
            if (!LeafEnum.isLeaf(parent.getIsLeaf())) {
                Integer maxOrderValue = goodsCategoryMapper.selectMaxOrderValueByParentId(parentId);
                orderValue = maxOrderValue == null ? 1 : maxOrderValue + 1;
            } else {
                needUpdateParent = true;
            }
            dto.setChildNextOrderValue(orderValue);
            map.put(addVo.getParentId(), dto);
        }
        //新增节点
        addSingle(addVo, dto.getGoodsCategory(), dto.getChildNextOrderValue());

        dto.setChildNextOrderValue(dto.getChildNextOrderValue() + 1);
        if (needUpdateParent) {
            goodsCategoryMapper.updateLeafByCategory(LeafEnum.NOT_LEAF.code, parentId);
        }
    }

    private void addSingle(GoodsCategoryAddVo addVo, GoodsCategory parent, int orderValue) {
        LeafEnum leafEnum = LeafEnum.NOT_LEAF;
        if (CollectionUtils.isEmpty(addVo.getChilds())) {
            leafEnum = LeafEnum.LEAF;
        }
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setCategoryCode(addVo.getCategoryCode());
        goodsCategory.setCategoryName(addVo.getCategoryName());
        goodsCategory.setLevel(parent.getLevel() + 1);
        goodsCategory.setOrderValue(orderValue);
        goodsCategory.setIsLeaf(leafEnum.code);
        goodsCategory.setStatus(StatusEnum.VALID.code);
        goodsCategory.setParentId(parent.getCategoryId());
        goodsCategory.setCreatedUser(addVo.getCreatedUser());
        int categoryId = goodsCategoryMapper.insertSelective(goodsCategory);
        //goodsCategory.setCategoryId(categoryId);
        if (leafEnum == LeafEnum.NOT_LEAF) {
            //处理子节点
            addChilds(addVo.getChilds(), goodsCategory);
        }
    }

    private void addChilds(List<GoodsCategoryAddVo> childs, GoodsCategory parent) {
        int orderValue = 0;
        childs.forEach(child -> {
            checkChild(child);
            addSingle(child, parent, orderValue + 1);
        });
    }

    private void checkChild(GoodsCategoryAddVo addVo) {
        if (StringUtils.isEmpty(addVo.getCategoryCode())) {
            log.error(ResultEnum.GOODS_ADD_CATEGORY_2 + " 入参 {}", addVo);
            throw new BusinessException(ResultEnum.GOODS_ADD_CATEGORY_2);
        }
        if (StringUtils.isEmpty(addVo.getCategoryName())) {
            log.error(ResultEnum.GOODS_ADD_CATEGORY_3 + " 入参 {}", addVo);
            throw new BusinessException(ResultEnum.GOODS_ADD_CATEGORY_3);
        }
    }

    @Override
    public void updateCategory(List<GoodsCategoryUpdateVo> updateVos) {
        if (CollectionUtils.isEmpty(updateVos)) {
            throw new BusinessException(ResultEnum.REQ_PARAM_NULL);
        }
        updateVos.forEach(updateVo -> {
            GoodsCategory goodsCategory = goodsCategoryMapper.selectByCategoryId(updateVo.getCategoryId());
            if (goodsCategory == null) {
                throw new BusinessException(ResultEnum.GOODS_UPDATE_CATEGORY);
            }
            GoodsCategory updateCategory = new GoodsCategory();
            BeanUtils.copyProperties(updateVo, updateCategory);
            goodsCategoryMapper.updateSelective(updateCategory);
        });

    }

    private GoodsCategory findByCategoryId(Integer categoryId) {
        if (categoryId == GoodsCategoryConstants.ROOT_CATEGORY_ID) {
            return GoodsCategoryUtils.virtualRoot();
        } else {
            return goodsCategoryMapper.selectByCategoryId(categoryId);
        }
    }


    private GoodsCategoryRo eoToVo(GoodsCategory goodsCategory) {
        if (goodsCategory == null) {
            return null;
        }
        GoodsCategoryRo ro = new GoodsCategoryRo();
        BeanUtils.copyProperties(goodsCategory, ro);
        ro.setIsLeaf(LeafEnum.isLeaf(goodsCategory.getIsLeaf()));
        return ro;
    }
}
