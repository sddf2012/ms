package com.my.goods.service.impl;

import com.my.goods.domain.dto.GoodsCategoryAddDto;
import com.my.goods.domain.entity.GoodsCategory;
import com.my.goods.domain.vo.GoodsCategoryAddVo;
import com.my.goods.domain.vo.GoodsCategoryRo;
import com.my.goods.domain.vo.GoodsCategoryUpdateVo;
import com.my.goods.repo.GoodsCategoryMapper;
import com.my.goods.service.GoodsCategoryManageService;
import com.my.include.common.constants.enums.LeafEnum;
import com.my.include.common.constants.enums.ResultEnum;
import com.my.include.common.constants.enums.StatusEnum;
import com.my.include.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
            goodsCategoryMapper.updateUnValidByCategoryId(StatusEnum.UN_VALID.code, categoryId);
            List<Integer> parentIds = new ArrayList<>();
            getParentIds(result, parentIds);
            if (!parentIds.isEmpty()) {
                goodsCategoryMapper.updateUnValidByParentIds(StatusEnum.UN_VALID.code, parentIds);
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
        boolean needUpdateParent = false;
        if (dto == null) {
            GoodsCategory parent = goodsCategoryMapper.selectByCategoryId(addVo.getParentId());
            if (parent == null) {
                throw new BusinessException(ResultEnum.GOODS_ADD_CATEGORY);
            }
            dto = new GoodsCategoryAddDto();
            dto.setGoodsCategory(parent);
            int orderValue = 1;
            if (!LeafEnum.isLeaf(parent.getIsLeaf())) {
                Integer maxOrderValue = goodsCategoryMapper.selectMaxOrderValueByParentId(addVo.getParentId());
                orderValue = maxOrderValue == null ? 1 : maxOrderValue + 1;
            } else {
                needUpdateParent = true;
            }
            dto.setChildNextOrderValue(orderValue);
            map.put(addVo.getParentId(), dto);
        }
        addSingle(addVo, dto.getGoodsCategory(), dto.getChildNextOrderValue());
        dto.setChildNextOrderValue(dto.getChildNextOrderValue() + 1);
        if (needUpdateParent) {
            goodsCategoryMapper.updateLeafByCategory(LeafEnum.NOT_LEAF.code, addVo.getParentId());
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
        goodsCategory.setCategoryId(categoryId);
        if (leafEnum == LeafEnum.NOT_LEAF) {
            addChilds(addVo.getChilds(), goodsCategory);
        }
    }

    private void addChilds(List<GoodsCategoryAddVo> childs, GoodsCategory parent) {
        int orderValue = 0;
        childs.forEach(child -> addSingle(child, parent, orderValue + 1));
    }

    @Override
    public void updateCategory(GoodsCategoryUpdateVo updateVo) {
        if (updateVo == null) {
            throw new BusinessException(ResultEnum.REQ_PARAM_NULL);
        }
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByCategoryId(updateVo.getCategoryId());
        if (goodsCategory == null) {
            throw new BusinessException(ResultEnum.GOODS_UPDATE_CATEGORY);
        }
        GoodsCategory update = new GoodsCategory();
        boolean updateOrder = false;
        if (!updateVo.getParentId().equals(goodsCategory.getParentId())) {
            GoodsCategory newParent = goodsCategoryMapper.selectByCategoryId(updateVo.getParentId());
            if (newParent == null) {
                throw new BusinessException(ResultEnum.GOODS_UPDATE_CATEGORY);
            }
            update.setLevel(newParent.getLevel());
            updateOrder = true;
        }
        if (!updateVo.getOrderValue().equals(goodsCategory.getOrderValue())) {
            updateOrder = true;
        }
        update.setCategoryCode(updateVo.getCategoryCode());
        update.setCategoryName(updateVo.getCategoryName());
        update.setUpdatedUser(updateVo.getUpdatedUser());
        goodsCategoryMapper.updateSelective(goodsCategory);

        if (updateOrder) {
            goodsCategoryMapper.updateOrderValueByParentId(updateVo.getParentId(), updateVo.getCategoryId(), updateVo.getOrderValue());
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
