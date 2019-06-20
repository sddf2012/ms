package com.my.stock.controller;

import com.my.include.common.domain.vo.RespVo;
import com.my.stock.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/20 11:04
 */
@Api
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation("根据商品ids查询库存")
    @PostMapping("/selectByIds")
    public RespVo<Map<Integer, Integer>> selectByIds(@RequestBody List<Integer> ids) {
        Map<Integer, Integer> map = stockService.getItemStock(ids);
        return RespVo.buildSuccess(map);
    }
}
