package com.mysql.mybatis.test.demo.common.aspect;


import com.mysql.mybatis.test.demo.common.annotation.MthdLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class MthdAspect {
//	@Around("@annotation(com.mysql.mybatis.test.demo.common.annotation.MthdLogger)")
//	public Object methodLogAspect(ProceedingJoinPoint joinPoint) throws Throwable {
//		
//	}

    @Around("@annotation(com.mysql.mybatis.test.demo.common.annotation.MthdLogger)")
    public Object handlerLog(ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Method method = methodSignature.getMethod();

        MthdLogger methodLogging = method.getAnnotation(MthdLogger.class);

        if(methodLogging.isArgumentLogging() && joinPoint.getArgs() != null){
            StringBuilder requestInfo = new StringBuilder();

            for(int i = 0; i < joinPoint.getArgs().length; i++){
                requestInfo.append(String.format("%s : %s", method.getParameters()[i].getName(), joinPoint.getArgs()[i])).append("\n");
            }

            if(requestInfo != null && !requestInfo.isEmpty()) {
                // GUID, METHOD NM, PARAM INFO
                log.info("[REQUEST PARAMETER INFO] :: guid={}, methodName={}, paramInfo=[{}]", MDC.get("guid"), method.getName(), requestInfo);
            }
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        stopWatch.stop();

        if(methodLogging.isResultLogging()){
            log.info("[RESPONSE INFO] :: [{}] - {}ms", result, stopWatch.getTotalTimeMillis());
        }

        return result;
    }
}
