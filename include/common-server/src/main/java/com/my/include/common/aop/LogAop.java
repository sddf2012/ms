package com.my.include.common.aop;

import com.my.include.common.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/6/4 15:42
 */
@Component
@Aspect
public class LogAop {
    @Pointcut("execution(* com.my.*.controller..*Controller.*(..))")
    private void logPoint() {
    }

    @Around("logPoint()")
    public Object log(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Object result;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        String description = null;
        if (apiOperation != null) {
            description = apiOperation.value();
        }
        if (StringUtils.isEmpty(description)) {
            description = method.getName();
        }

        String[] paramNames = signature.getParameterNames();
        StringBuilder format = new StringBuilder(description + "--请求入参->");
        if (paramNames != null && paramNames.length > 0) {
            for (String paramName : paramNames) {
                format.append(paramName).append(":{};");
            }
        }
        String reqInfo = format.toString();
        String respInfo = description + "--请求出参->{}";
        String errInfo = description + "--请求异常!";
        Logger logger = LoggerFactory.getLogger(signature.getDeclaringType());

        logger.info(reqInfo, args);
        try {
            result = joinPoint.proceed(args);
            logger.info(respInfo, result);
        } catch (BusinessException businessException) {
            logger.error(errInfo, businessException);
            throw businessException;
        } catch (Throwable throwable) {
            logger.error(errInfo, throwable);
            throw new RuntimeException(throwable);
        }
        return result;
    }
}
