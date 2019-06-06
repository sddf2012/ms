package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategoryAttr;
import com.my.goods.domain.entity.extension.GoodsCategoryAttrDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryAttrMapper {
    int insert(GoodsCategoryAttr record);

    int insertSelective(GoodsCategoryAttr record);

    List<GoodsCategoryAttrDetail> selectByCategoryId(@Param("categoryId") int categoryId);
}