package com.my.goods.repo;

import com.my.goods.domain.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {
    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    List<GoodsCategory> selectByParentId(@Param("parentId") int parentId);

    GoodsCategory selectByCategoryId(@Param("categoryId") int categoryId);

    int updateUnValidByCategoryId(@Param("status") int status, @Param("categoryId") int categoryId);

    int updateUnValidByParentIds(@Param("status") int status, @Param("parentIds") List<Integer> parentIds);

    int updateLeafByCategory(@Param("isLeaf") int isLeaf, @Param("categoryId") int categoryId);

    Integer selectMaxOrderValueByParentId(@Param("parentId") int parentId);

    int updateSelective(GoodsCategory record);

    /**
     * parentId下节点的排序值大于orderValue的数据排序值加1，不包含指定的categoryId
     *
     * @param parentId   父节点
     * @param categoryId 排除的节点
     * @param orderValue 排序值
     * @return int
     */
    int updateOrderValueByParentId(@Param("parentId") int parentId, @Param("categoryId") int categoryId, @Param("orderValue") int orderValue);

}