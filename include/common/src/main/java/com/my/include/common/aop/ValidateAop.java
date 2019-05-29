package com.my.include.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/5/29 9:25
 */
@Aspect
@Component
public class ValidateAop {
    @Autowired
    private LocalValidatorFactoryBean validator;

    private boolean failFast = true;

    @Pointcut(value = "execution(* com.my.*.service.*Service.*(..))")
    public void validator() {

    }

    @Before(value = "validator()")
    public void validate(JoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
        if (objects == null || objects.length < 1) {
            return;
        }

        Set<ConstraintViolation<Object>> validateResult = new HashSet<>();
        for (Object object : objects) {
            handleArg(validateResult, object);
        }
        if (!validateResult.isEmpty()) {
            throw new ConstraintViolationException(validateResult);
        }
    }


    private void handleArg(Set<ConstraintViolation<Object>> validateResult, Object object) {
        if (ClassUtils.isAssignable(List.class, object.getClass())) {
            ((List) object).forEach(vo -> validateObject(validateResult, vo));
        } else {
            validateObject(validateResult, object);
        }
    }

    private void validateObject(Set<ConstraintViolation<Object>> validateResult, Object object) {
        Set<ConstraintViolation<Object>> set = validator.validate(object);
        if (!CollectionUtils.isEmpty(set)) {
            if (failFast) {
                throw new ConstraintViolationException(set);
            } else {
                validateResult.addAll(set);
            }
        }
    }
}
