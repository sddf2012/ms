package com.my.stock.repo;

import com.my.stock.domain.entity.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByIds(@Param("ids") List<Integer> ids);
}