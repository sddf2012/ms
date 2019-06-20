package com.my.goods.repo;

import com.my.goods.domain.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 10:30
 */
public interface ItemMapper {
    int insert(Item record);

    int insertSelective(Item record);

    List<Item> getItemByCaId(@Param("caId") Integer caId,@Param("status") Integer status, @Param("pageNum") int pageNum, @Param("pageSize")int pageSize);
}
