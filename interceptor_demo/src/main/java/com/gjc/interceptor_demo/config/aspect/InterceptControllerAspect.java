package com.gjc.interceptor_demo.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InterceptControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(InterceptControllerAspect.class);

    @Pointcut("execution(* com.gjc.interceptor_demo.web.*.*(..))")
    public void interceptController() {
    }

    @Around("interceptController()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("aspect before.");
        try {
            return joinPoint.proceed();
        } finally {
            logger.info("aspect after.");
        }
    }


}
