package com.my.include.common.exception;

import com.my.include.common.constants.enums.RespMessageEnum;
import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 16:26
 */
@Data
public class BusinessException extends RuntimeException {
    private RespMessageEnum respMessageEnum;

    private String errCode;

    private String errMsg;

    public BusinessException(RespMessageEnum result) {
        super(result.msg);
        this.errCode = result.code;
        this.errMsg = result.msg;
    }

    public BusinessException(RespMessageEnum result, Throwable cause) {
        super(result.msg, cause);
        this.errCode = result.code;
    }

    public BusinessException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BusinessException(String errCode, String errMsg, Throwable cause) {
        super(cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.errCode = RespMessageEnum.ERROR.code;
        this.errMsg = RespMessageEnum.ERROR.msg;
    }

}
