package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsSku;

public interface GoodsSkuMapper {
    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);
}