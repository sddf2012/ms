package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsSkuAttr;

public interface GoodsSkuAttrMapper {
    int insert(GoodsSkuAttr record);

    int insertSelective(GoodsSkuAttr record);
}