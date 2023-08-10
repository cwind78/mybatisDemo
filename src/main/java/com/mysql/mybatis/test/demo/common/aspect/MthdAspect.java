package com.mysql.mybatis.test.demo.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class MthdAspect {
//	@Around("@annotation(com.mysql.mybatis.test.demo.common.annotation.MthdLogger)")
//	public Object methodLogAspect(ProceedingJoinPoint joinPoint) throws Throwable {
//		
//	}
}
