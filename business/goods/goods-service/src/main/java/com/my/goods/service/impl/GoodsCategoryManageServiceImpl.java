package com.my.goods.service.impl;

import com.my.goods.domain.entity.GoodsCategory;
import com.my.goods.domain.vo.GoodsCategoryResultVo;
import com.my.goods.domain.vo.GoodsCategorySaveVo;
import com.my.goods.repo.GoodsCategoryMapper;
import com.my.goods.service.GoodsCategoryManageService;
import com.my.include.common.constants.enums.LeafEnum;
import com.my.include.common.constants.enums.RespMessageEnum;
import com.my.include.common.constants.enums.StatusEnum;
import com.my.include.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public List<GoodsCategoryResultVo> selectOneByParentId(int parentId) {
        List<GoodsCategory> list = goodsCategoryMapper.selectByParentId(parentId);
        if (!CollectionUtils.isEmpty(list)) {
            return list.stream().map(this::entityToRo).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<GoodsCategoryResultVo> selectAllByParentId(int parentId) {
        List<GoodsCategoryResultVo> result = selectOneByParentId(parentId);
        if (!CollectionUtils.isEmpty(result)) {
            result.forEach(parent -> {
                if (!parent.getIsLeaf()) {
                    parent.setChildren(selectAllByParentId(parent.getCategoryId()));
                }
            });
        }
        return result;
    }

    @Override
    public GoodsCategoryResultVo selectOneById(int categoryId) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByCategoryId(categoryId);
        return entityToRo(goodsCategory);
    }

    @Override
    public GoodsCategoryResultVo selectAllById(int categoryId) {
        GoodsCategoryResultVo result = selectOneById(categoryId);
        if (result != null && !result.getIsLeaf()) {
            result.setChildren(selectAllByParentId(result.getCategoryId()));
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByCategoryId(int categoryId) {
        GoodsCategoryResultVo result = selectAllById(categoryId);
        if (result != null) {
            goodsCategoryMapper.updateStatusByCategoryId(StatusEnum.UN_VALID.code, categoryId);
            List<Integer> parentIds = new ArrayList<>();
            getParentIds(result, parentIds);
            if (!parentIds.isEmpty()) {
                goodsCategoryMapper.updateStatusByParentIds(StatusEnum.UN_VALID.code, parentIds);
            }
        }
    }

    private void getParentIds(GoodsCategoryResultVo ro, List<Integer> list) {
        List<GoodsCategoryResultVo> childs = ro.getChildren();
        if (!CollectionUtils.isEmpty(childs)) {
            list.add(ro.getCategoryId());
            childs.forEach(child -> getParentIds(child, list));
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public GoodsCategoryResultVo saveCategory(GoodsCategorySaveVo saveVo) {
        if (StringUtils.isEmpty(saveVo.getCategoryId())) {
            return addCategory(saveVo);
        } else {
            return updateCategory(saveVo);
        }
    }

    private GoodsCategoryResultVo addCategory(GoodsCategorySaveVo saveVo) {
        String categoryCode = saveVo.getCategoryCode();
        Integer parentId = saveVo.getParentId();
        //校验categoryCode是否已存在
        int i = goodsCategoryMapper.selectCountByCategoryCode(categoryCode);
        String errMsg;
        if (i > 0) {
            errMsg = RespMessageEnum.GOODS_CATEGORY_SAVE_4.formatMsg(categoryCode);
            throw new BusinessException(RespMessageEnum.GOODS_CATEGORY_SAVE_4.code, errMsg);
        }
        //校验父节点是否存在
        GoodsCategory parent = goodsCategoryMapper.selectByCategoryId(parentId);
        if (parent == null) {
            errMsg = RespMessageEnum.GOODS_CATEGORY_SAVE_1.formatMsg(parentId);
            throw new BusinessException(RespMessageEnum.GOODS_CATEGORY_SAVE_1.code, errMsg);
        }
        //获取新增节点的排序值
        int orderValue = 1;
        boolean needUpdateParent = false;
        if (!LeafEnum.isLeaf(parent.getIsLeaf())) {
            Integer maxOrderValue = goodsCategoryMapper.selectMaxOrderValueByParentId(parentId);
            orderValue = maxOrderValue == null ? 1 : maxOrderValue + 1;
        } else {
            needUpdateParent = true;
        }
        //新增节点
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setCategoryCode(categoryCode);
        goodsCategory.setCategoryName(saveVo.getCategoryName());
        goodsCategory.setLevel(parent.getLevel() + 1);
        goodsCategory.setOrderValue(orderValue);
        goodsCategory.setIsLeaf(LeafEnum.LEAF.code);
        goodsCategory.setStatus(StatusEnum.VALID.code);
        goodsCategory.setParentId(parent.getCategoryId());
        goodsCategory.setCreatedUser(saveVo.getOperator());
        goodsCategoryMapper.insertSelective(goodsCategory);
        //更新父节点
        if (needUpdateParent) {
            goodsCategoryMapper.updateLeafByCategoryId(LeafEnum.NOT_LEAF.code, parentId);
        }
        return entityToRo(goodsCategory);
    }

    private GoodsCategoryResultVo updateCategory(GoodsCategorySaveVo saveVo) {
        Integer categoryId = saveVo.getCategoryId();
        String categoryCode = saveVo.getCategoryCode();
        String errMsg;
        GoodsCategory goodsCategory = goodsCategoryMapper.selectByCategoryId(categoryId);
        if (goodsCategory == null) {
            errMsg = RespMessageEnum.GOODS_CATEGORY_SAVE_5.formatMsg(categoryId);
            throw new BusinessException(RespMessageEnum.GOODS_CATEGORY_SAVE_5.code, errMsg);
        }
        if (!goodsCategory.getCategoryCode().equals(categoryCode)) {
            int i = goodsCategoryMapper.selectCountByCategoryCodeExcludeId(categoryCode, categoryId);
            if (i > 0) {
                errMsg = RespMessageEnum.GOODS_CATEGORY_SAVE_4.formatMsg(categoryCode);
                throw new BusinessException(RespMessageEnum.GOODS_CATEGORY_SAVE_4.code, errMsg);
            }
        }
        goodsCategory.setCategoryCode(categoryCode);
        goodsCategory.setCategoryName(saveVo.getCategoryName());
        goodsCategoryMapper.updateSelective(goodsCategory);
        return entityToRo(goodsCategory);
    }

    private GoodsCategoryResultVo entityToRo(GoodsCategory goodsCategory) {
        if (goodsCategory == null) {
            return null;
        }
        GoodsCategoryResultVo ro = new GoodsCategoryResultVo();
        BeanUtils.copyProperties(goodsCategory, ro);
        ro.setIsLeaf(LeafEnum.isLeaf(goodsCategory.getIsLeaf()));
        return ro;
    }
}
