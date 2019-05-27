package com.my.goods.service;

import com.my.goods.domain.vo.GoodsCategoryAddVo;
import com.my.goods.domain.vo.GoodsCategoryRo;
import com.my.goods.domain.vo.GoodsCategoryUpdateVo;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:07
 */
public interface GoodsCategoryManageService {
    List<GoodsCategoryRo> selectOneByParentId(int parentId);

    List<GoodsCategoryRo> selectAllByParentId(int parentId);

    GoodsCategoryRo selectOneById(int categoryId);

    GoodsCategoryRo selectAllById(int categoryId);

    void deleteByCategoryId(int categoryId);

    void addCategory(List<GoodsCategoryAddVo> addVos);

    void updateCategory(GoodsCategoryUpdateVo updateVo);
}
