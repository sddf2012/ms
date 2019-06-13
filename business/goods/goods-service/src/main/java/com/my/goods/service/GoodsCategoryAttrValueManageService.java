package com.my.goods.service;

import com.my.goods.domain.vo.GoodsCategoryAttrValueResultVo;
import com.my.goods.domain.vo.GoodsCategoryAttrValueSaveVo;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 14:13
 */
public interface GoodsCategoryAttrValueManageService {
    List<GoodsCategoryAttrValueResultVo> selectByCaId(Integer caId);

    List<GoodsCategoryAttrValueResultVo> selectByCaIdAndValue(Integer caId,String value);

    int deleteById(Integer cavId);

    GoodsCategoryAttrValueResultVo saveAttrValue(GoodsCategoryAttrValueSaveVo saveVo);
}
