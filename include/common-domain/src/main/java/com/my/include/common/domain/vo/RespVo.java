package com.my.include.common.domain.vo;

import com.my.include.common.constants.enums.RespMessageEnum;
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

    public RespVo() {
    }

    public RespVo(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public RespVo(RespMessageEnum respMessageEnum) {
        this.respCode = respMessageEnum.code;
        this.respMsg = respMessageEnum.msg;
    }

    public RespVo(RespMessageEnum respMessageEnum, T data) {
        this(respMessageEnum);
        this.data = data;
    }

    public static <T> RespVo<T> buildSuccess() {
        return new RespVo<>(RespMessageEnum.SUCCESS);
    }

    public static RespVo<String> buildStringSuccess() {
        return new RespVo<>(RespMessageEnum.SUCCESS, "success");
    }

    public static <T> RespVo<T> buildSuccess(T data) {
        RespVo<T> respVo = new RespVo<>(RespMessageEnum.SUCCESS);
        respVo.setData(data);
        return respVo;
    }

    public static <T> RespVo<T> buildFail(RespMessageEnum respMessageEnum) {
        return new RespVo<>(respMessageEnum);
    }

    public static <T> RespVo<T> buildFail(String code, String msg) {
        return new RespVo<>(code, msg);
    }

}
