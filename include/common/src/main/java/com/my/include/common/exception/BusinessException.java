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
    private ResultEnum resultEnum;

    public BusinessException(ResultEnum result) {
        super(result.msg);
        this.resultEnum = result;
    }

    public BusinessException(ResultEnum result, Throwable cause) {
        super(result.msg, cause);
        this.resultEnum = result;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.resultEnum = ResultEnum.ERROR;
    }

}
