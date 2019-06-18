package com.my.goods.service;

import com.my.goods.domain.vo.GoodsCategoryAttrResultVo;
import com.my.goods.domain.vo.GoodsCategoryAttrSaveVo;
import com.my.include.common.vo.PageResp;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/6 10:04
 */
public interface GoodsCategoryAttrManageService {
    List<GoodsCategoryAttrResultVo> selectByCategoryId(Integer categoryId);

    PageResp<GoodsCategoryAttrResultVo> selectByCategoryIdPage(Integer categoryId, int pageNum, int pageSize);

    GoodsCategoryAttrResultVo saveCa(GoodsCategoryAttrSaveVo saveVo);

    void deleteCaById(Integer caId);
}
