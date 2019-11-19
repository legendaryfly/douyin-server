package com.anoyi.douyin.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.anoyi.douyin.entity.RespFactory;

/**
 * aop 统一参数校验
 * 校验 controller 中带 BindingResult 参数的方法
 */
@Aspect
@Component
@Order(2)
public class BindingResultAspect {
    @Pointcut("execution(public * com.anoyi.*.controller.*Controller.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    List<FieldError> fieldErrors = result.getFieldErrors();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0, size = fieldErrors.size(); i < size; i++) {
                        FieldError fieldError = fieldErrors.get(i);
                        sb.append(fieldError.getDefaultMessage());
                        if (i != size - 1) {
                            sb.append(";");
                        }
                    }
                    return RespFactory.error(sb.toString());
                }
            }
        }
        return joinPoint.proceed();
    }
}
