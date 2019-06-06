package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
    /**
     * insert
     *
     * @param record entity
     * @return int
     */
    int insert(GoodsCategory record);

    /**
     * insertSelective
     *
     * @param record entity
     * @return int
     */
    int insertSelective(GoodsCategory record);

    /**
     * 根据父节点查询分类
     *
     * @param parentId 父节点
     * @return 分类集合
     */
    List<GoodsCategory> selectByParentId(@Param("parentId") int parentId);

    /**
     * 根据分类id查询分类
     *
     * @param categoryId 分类id
     * @return 分类
     */
    GoodsCategory selectByCategoryId(@Param("categoryId") int categoryId);

    /**
     * 根据分类id更新分类状态为指定值
     *
     * @param status     分类状态
     * @param categoryId 分类id
     * @return 影响的数据
     */
    int updateStatusByCategoryId(@Param("status") int status, @Param("categoryId") int categoryId);

    /**
     * 根据父节点id更新分类状态为指定值
     *
     * @param status    分类状态
     * @param parentIds 父节点id
     * @return 影响的数据
     */
    int updateStatusByParentIds(@Param("status") int status, @Param("parentIds") List<Integer> parentIds);

    /**
     * 根据分类id更新分类叶子节点值
     *
     * @param isLeaf     是否为叶子节点
     * @param categoryId 分类id
     * @return 影响的数据
     */
    int updateLeafByCategoryId(@Param("isLeaf") int isLeaf, @Param("categoryId") int categoryId);

    /**
     * 查询父节点下的最大orderValue值
     *
     * @param parentId 父节点
     * @return 最大orderValue值
     */
    Integer selectMaxOrderValueByParentId(@Param("parentId") int parentId);

    /**
     * updateSelective
     *
     * @param record entity
     * @return 影响的数据
     */
    int updateSelective(GoodsCategory record);

    /**
     * 判断code是否重复
     *
     * @param categoryCode 分类代码
     * @return count
     */
    int selectCountByCategoryCode(@Param("categoryCode") String categoryCode);

    /**
     * 判断code是否重复，不包含指定的id
     *
     * @param categoryCode 分类代码
     * @param categoryId   分类id
     * @return count
     */
    int selectCountByCategoryCodeExcludeId(@Param("categoryCode") String categoryCode, @Param("categoryId") Integer categoryId);

}