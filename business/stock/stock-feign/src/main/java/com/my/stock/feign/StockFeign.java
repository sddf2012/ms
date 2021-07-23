package com.my.stock.feign;

import com.my.include.common.domain.vo.RespVo;
import com.my.stock.feign.callback.StockFeignCallback;
import com.my.stock.feign.config.StockFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/20 11:08
 */
@FeignClient(value = "stock", path = "/stock", fallback = StockFeignCallback.class, configuration = StockFeignConfig.class)
public interface StockFeign {
    @PostMapping(value = "/selectByIds")
    RespVo<Map<Integer, Integer>> selectByIds(@RequestBody List<Integer> ids);
}
