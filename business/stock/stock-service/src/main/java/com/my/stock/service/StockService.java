package com.my.stock.service;

import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 19:47
 */
public interface StockService {
    Map<Integer,Integer> getItemStock(List<Integer> itemIds);
}
