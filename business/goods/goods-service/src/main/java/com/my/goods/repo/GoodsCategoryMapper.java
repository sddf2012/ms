package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategory;

public interface GoodsCategoryMapper {
    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);
}