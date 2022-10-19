package com.ssafy.mvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component // 빈등록!
@Aspect // Aspect관련 클래스 파일임을 알려줌!
@Slf4j // 로그 찍기위해서는 필요
public class LoggingAspect {
	
	// @Before(value="execution(* com.ssafy.mvc.model.service.*.*(..))")	// service패키지 안에 있는 모든 클래스의 모든 메소드
	// @Before(value="execution(* com.ssafy.mvc.model.service.BookServiceImpl.selectAll(..))") -> selectAll()을 포함하는 클래스를 프록시 해버림
	 @Before(value="execution(* com.ssafy.mvc.model.service.*.*(..)) || execution(* com.ssafy.mvc.controller.*.*(..))")
	public void logging(JoinPoint jp) {
		
		Signature sig = jp.getSignature();	// 메소드에 대한 설명 정보
		Object[] args = jp.getArgs();
		
		log.debug("메서드 선언부: {}, 전달 파라미터: {}", sig, args);
	}
	
	 @Around(value="execution(* com.ssafy.mvc.model.dao.BookDaoImpl.selectAll())")	// 메소드 실행되는지 얼마나 걸리는지 알 수 있음
	 public Object calcTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		 // 원래 메소드를 실행하는 코드
		 long start = System.currentTimeMillis();
		 Object result = proceedingJoinPoint.proceed();
		 long end =  System.currentTimeMillis();
		 
		 log.debug("수행 시간 : {} ", end-start);
		 
		 return result;
	 }
}
