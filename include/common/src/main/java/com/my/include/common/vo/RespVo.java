package com.my.include.common.vo;

import com.my.include.common.constants.enums.ResultEnum;
import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 14:30
 */
@Data
public class RespVo<T> {

    private String respCode;

    private String respMsg;

    private T data;

    public RespVo(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public RespVo(ResultEnum resultEnum) {
        this.respCode = resultEnum.code;
        this.respMsg = resultEnum.msg;
    }

    public RespVo(ResultEnum resultEnum, T data) {
        this(resultEnum);
        this.data = data;
    }

    public static <T> RespVo<T> buildSuccess() {
        return new RespVo<>(ResultEnum.SUCCESS);
    }

    public static RespVo<String> buildStringSuccess() {
        return new RespVo<>(ResultEnum.SUCCESS, "success");
    }

    public static <T> RespVo<T> buildSuccess(T data) {
        RespVo<T> respVo = new RespVo<>(ResultEnum.SUCCESS);
        respVo.setData(data);
        return respVo;
    }

    public static <T> RespVo<T> buildFail(ResultEnum resultEnum) {
        return new RespVo<>(resultEnum);
    }

    public static <T> RespVo<T> buildFail(String code, String msg) {
        return new RespVo<>(code, msg);
    }

}
