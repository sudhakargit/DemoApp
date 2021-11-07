package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Configuration
@Aspect
public class AspectConfig {
 Logger logger = LoggerFactory.getLogger(getClass());
 
 @Before(value = "execution(* com.example.demo.controller.*.*(..))")
 public void beforeAdvice(JoinPoint joinPoint) {
	 logger.info("Inside before advice");
 }
 @After(value = "execution(* com.example.demo.controller.*.*(..))")
 public void afterAdvice(JoinPoint joinPoint) {
	 logger.info("Inside before advice");
 }
 @AfterReturning(value = "execution(* com.example.demo.controller.*.*(..))",returning = "returningObject")
 public void afterReturningAdvice(JoinPoint joinPoint, Object returningObject) {
	 logger.info("Response = " + returningObject);
 }
}
