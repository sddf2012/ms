package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategoryAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryAttrValueMapper {
    int insert(GoodsCategoryAttrValue record);

    int insertSelective(GoodsCategoryAttrValue record);

    List<GoodsCategoryAttrValue> selectByCaId(@Param("caId") Integer caId);
}