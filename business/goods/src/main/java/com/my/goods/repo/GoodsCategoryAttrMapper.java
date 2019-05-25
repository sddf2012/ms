package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategoryAttr;

public interface GoodsCategoryAttrMapper {
    int insert(GoodsCategoryAttr record);

    int insertSelective(GoodsCategoryAttr record);
}