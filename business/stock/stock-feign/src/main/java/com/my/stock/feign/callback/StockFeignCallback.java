package com.my.stock.feign.callback;

import com.my.include.common.constants.enums.RespMessageEnum;
import com.my.include.common.domain.vo.RespVo;
import com.my.stock.feign.StockFeign;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/20 11:24
 */
@Component
public class StockFeignCallback implements StockFeign {
    /*@Override
    public StockFeign create(Throwable cause) {
        String code=RespMessageEnum.FEIGN_ERROR.code;
        String errMsg=RespMessageEnum.FEIGN_ERROR.formatMsg(cause.getMessage());
        return new StockFeign() {
            @Override
            public RespVo<Map<Integer, Integer>> selectByIds(List<Integer> ids) {
                return RespVo.buildFail(code,errMsg);
            }
        };
    }*/

    @Override
    public RespVo<Map<Integer, Integer>> selectByIds(List<Integer> ids) {
        return RespVo.buildFail(RespMessageEnum.FEIGN_ERROR);
    }
}
