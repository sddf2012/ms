package com.my.include.common.exception;

import com.my.include.common.constants.enums.ResultEnum;
import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/27 16:26
 */
@Data
public class BusinessException extends RuntimeException {
    private String code;
    private ResultEnum result;

    public BusinessException(ResultEnum result) {
        super(result.msg);
        this.result = result;
    }

    public BusinessException(ResultEnum result, String message) {
        super(message);
        this.result = result;
    }

    public BusinessException(ResultEnum result, Throwable cause) {
        super(result.msg, cause);
        this.result = result;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.result = ResultEnum.ERROR;
    }

}
