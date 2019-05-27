package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsAttr;

public interface GoodsAttrMapper {
    int insert(GoodsAttr record);

    int insertSelective(GoodsAttr record);
}