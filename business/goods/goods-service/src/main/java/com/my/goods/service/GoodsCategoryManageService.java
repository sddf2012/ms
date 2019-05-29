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
    /**
     * 根据父节点查询分类,不包含子节点
     *
     * @param parentId 父节点
     * @return 分类集合
     */
    List<GoodsCategoryRo> selectOneByParentId(int parentId);

    /**
     * 根据父节点查询分类,包含子节点
     *
     * @param parentId 父节点
     * @return 分类集合
     */
    List<GoodsCategoryRo> selectAllByParentId(int parentId);

    /**
     * 根据categoryId查询分类,不包含子节点
     *
     * @param categoryId categoryId
     * @return 分类
     */
    GoodsCategoryRo selectOneById(int categoryId);

    /**
     * 根据categoryId查询分类,包含子节点
     *
     * @param categoryId categoryId
     * @return 分类
     */
    GoodsCategoryRo selectAllById(int categoryId);

    /**
     * 删除分类
     *
     * @param categoryId categoryId
     */
    void deleteByCategoryId(int categoryId);

    /**
     * 新增分类
     *
     * @param addVos 分类集合
     */
    void addCategory(List<GoodsCategoryAddVo> addVos);

    /**
     * 更新分类
     *
     * @param updateVos 分类集合
     */
    void updateCategory(List<GoodsCategoryUpdateVo> updateVos);
}
