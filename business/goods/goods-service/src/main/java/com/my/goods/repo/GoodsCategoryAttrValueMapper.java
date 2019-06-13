package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategoryAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryAttrValueMapper {
    int insert(GoodsCategoryAttrValue record);

    int insertSelective(GoodsCategoryAttrValue record);

    int updateSelective(GoodsCategoryAttrValue record);

    GoodsCategoryAttrValue selectByCavId(@Param("cavId") Integer cavId);

    int selectByCaIdAndValueExcludeCavid(@Param("caId") Integer caId,@Param("value") String value,@Param("cavId") Integer cavId);

    List<GoodsCategoryAttrValue> selectByCaId(@Param("caId") Integer caId);

    List<GoodsCategoryAttrValue> selectByCaIdAndValueLike(@Param("caId") Integer caId, @Param("value") String value);

    GoodsCategoryAttrValue selectByCaIdAndValue(@Param("caId") Integer caId, @Param("value") String value);

    int deleteById(@Param("cavId")Integer cavId);
}