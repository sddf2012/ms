package com.my.include.common.utils;

import com.my.include.common.constants.enums.RespMessageEnum;
import com.my.include.common.domain.vo.RespVo;
import com.my.include.common.exception.BusinessException;
import org.slf4j.Logger;

import java.util.function.Supplier;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/20 20:14
 */
public class FeignUtils {
    public static  <T> T feignInvoke(Supplier<RespVo<T>> supplier, Logger log,String module,String interfaces){
        T t=null;
        try {
            RespVo<T> respVo = supplier.get();
            if (respVo == null) {
                log.error(RespMessageEnum.FEIGN_RESP_NULL.formatMsg(module, interfaces));
            } else if (!RespMessageEnum.SUCCESS.code.equals(respVo.getRespCode())) {
                log.error(RespMessageEnum.FEIGN_RESP_ERROR.formatMsg(module, interfaces, respVo.getRespCode() + " " + respVo.getRespMsg()));
            } else {
                t = respVo.getData();
            }
        } catch (Exception e) {
            log.error(RespMessageEnum.FEIGN_INVOKE_ERROR.formatMsg(module, interfaces, e.getMessage()));
        }
        return t;
    }

    public static  <T> T feignInvokeWithThrow(Supplier<RespVo<T>> supplier, Logger log,String module,String interfaces){
        T t;
        String errMsg;
        try {
            RespVo<T> respVo = supplier.get();
            if (respVo == null) {
                errMsg=RespMessageEnum.FEIGN_RESP_NULL.formatMsg(module, interfaces);
                log.error(errMsg);
                throw new BusinessException(RespMessageEnum.FEIGN_RESP_NULL.code,errMsg);
            } else if (!RespMessageEnum.SUCCESS.code.equals(respVo.getRespCode())) {
                errMsg=RespMessageEnum.FEIGN_RESP_ERROR.formatMsg(module, interfaces, respVo.getRespCode() + " " + respVo.getRespMsg());
                log.error(errMsg);
                throw new BusinessException(RespMessageEnum.FEIGN_RESP_ERROR.code,errMsg);
            } else {
                t = respVo.getData();
            }
        } catch (Exception e) {
            errMsg=RespMessageEnum.FEIGN_INVOKE_ERROR.formatMsg(module, interfaces,e.getMessage());
            log.error(errMsg);
            throw new BusinessException(RespMessageEnum.FEIGN_INVOKE_ERROR.code,errMsg);
        }
        return t;
    }
}
