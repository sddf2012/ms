package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsAttr;
import org.apache.ibatis.annotations.Param;

public interface GoodsAttrMapper {
    int insert(GoodsAttr record);

    int insertSelective(GoodsAttr record);

    String selectByAttrId(@Param("attrId") int attrId);
}