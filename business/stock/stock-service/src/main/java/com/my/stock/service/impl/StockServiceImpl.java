package com.my.stock.service.impl;

import com.my.stock.domain.entity.Stock;
import com.my.stock.repo.StockMapper;
import com.my.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/19 20:14
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public Map<Integer, Integer> getItemStock(List<Integer> itemIds) {
        if (CollectionUtils.isEmpty(itemIds)) {
            return null;
        }
        List<Stock> stocks = stockMapper.selectByIds(itemIds);
        if (CollectionUtils.isEmpty(stocks)) {
            return null;
        }
        Map<Integer, Integer> result = new HashMap<>();
        stocks.forEach(stock -> result.put(stock.getItemId(), stock.getTotal()));
        return result;
    }
}
