package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategoryAttr;
import com.my.goods.domain.entity.extension.GoodsCategoryAttrDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryAttrMapper {
    int insert(GoodsCategoryAttr record);

    int insertSelective(GoodsCategoryAttr record);

    int updateSelective(GoodsCategoryAttr record);

    GoodsCategoryAttr selectById(@Param("caId") int caId);

    GoodsCategoryAttr selectByCategoryIdAndAttrId(@Param("categoryId") int categoryId,@Param("attrId") int attrId);

    List<GoodsCategoryAttrDetail> selectByCategoryId(@Param("categoryId") int categoryId);

    List<GoodsCategoryAttrDetail> selectByCategoryIdPage(@Param("categoryId") int categoryId,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    int deleteCaById(@Param("caId") int caId);
}