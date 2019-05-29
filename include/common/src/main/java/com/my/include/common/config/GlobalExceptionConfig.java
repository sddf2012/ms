package com.my.include.common.config;

import com.my.include.common.constants.enums.ResultEnum;
import com.my.include.common.exception.BusinessException;
import com.my.include.common.vo.RespVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.Supplier;

import static org.springframework.util.CollectionUtils.toIterator;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/28 11:05
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionConfig {
    @ExceptionHandler(BusinessException.class)
    public RespVo<String> handleBusinessException(BusinessException exception) {
        return RespVo.buildFail(exception.getResultEnum());
    }

    @ExceptionHandler(ValidationException.class)
    public RespVo<String> handleConstraintViolationException(ValidationException ex) {
        String message = ResultEnum.REQ_PARAM_VALIDATE.msg + "\n" + ex.getMessage();
        log.error(message, ex);
        return RespVo.buildFail(ResultEnum.REQ_PARAM_VALIDATE.code, message);
    }

    @ExceptionHandler(Exception.class)
    public RespVo<String> handleException(HttpServletRequest request, Exception ex) {
        logError(request, ex);
        return RespVo.buildFail(ResultEnum.ERROR.code, ex.toString());
    }

    private void logError(HttpServletRequest request, Exception e) {
        StringBuilder messageBuilder = new StringBuilder("捕获到业务层异常:\n");
        messageBuilder.append(request.getMethod());
        messageBuilder.append(" ");
        messageBuilder.append(request.getRequestURI());
        messageBuilder.append("\nHeader:");
        toIterable(request::getHeaderNames).forEach(name -> {
            messageBuilder.append("\n");
            String value = request.getHeader(name);
            messageBuilder.append(name);
            messageBuilder.append(": ");
            messageBuilder.append(value);
        });
        messageBuilder.append("\n");
        if (request.getParameterMap().size() > 0) {
            StringBuilder parameters = getRequestParameters(request);
            messageBuilder.append(parameters);
        }
        log.error(messageBuilder.toString(), e);
    }

    private StringBuilder getRequestParameters(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder("request parameters:");
        stringBuilder.append("\n");
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            stringBuilder.append(k);
            stringBuilder.append(": ");
            stringBuilder.append(Arrays.toString(v));
            stringBuilder.append("\n");
        });
        return stringBuilder;
    }

    private <T> Iterable<T> toIterable(Supplier<Enumeration<T>> enumerationSupplier) {
        return () -> toIterator(enumerationSupplier.get());
    }
}
