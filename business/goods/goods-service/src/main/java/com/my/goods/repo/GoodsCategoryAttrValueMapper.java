package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategoryAttrValue;

public interface GoodsCategoryAttrValueMapper {
    int insert(GoodsCategoryAttrValue record);

    int insertSelective(GoodsCategoryAttrValue record);
}