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

    private String code;

    private String msg;

    private T data;

    public RespVo() {
    }

    public RespVo(ResultEnum resultEnum) {
        this.code = resultEnum.code;
        this.msg = resultEnum.msg;
    }

    public RespVo(ResultEnum resultEnum, T data) {
        this(resultEnum);
        this.data = data;
    }

    public static RespVo buildSuccess() {
        return new RespVo<>(ResultEnum.SUCCESS);
    }
}
