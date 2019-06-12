package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsAttrMapper {
    int insert(GoodsAttr record);

    int insertSelective(GoodsAttr record);

    String selectByAttrId(@Param("attrId") int attrId);

    List<GoodsAttr> selectByAttrName(@Param("attrName") String attrName);
}