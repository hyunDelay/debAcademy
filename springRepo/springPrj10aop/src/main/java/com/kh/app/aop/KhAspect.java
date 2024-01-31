package com.kh.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
@Aspect
public class KhAspect {
	
	// @Before("target(com.kh.app.board.dao.BoardDao)")
	//@AfterReturning() 정상적인 실행일때
	//@AfterTrowing // 잘되나 안되나 ?
	//@Around 실행되기 전이랑 실행된 후 둘다 동작
	//@After("target(com.kh.app.board.dao.BoardDao)")
	//@Around("target(com.kh.app.board.dao.BoardDao)")
	@Around("execution(public void com.kh.app.board.dao.BoardDao)")
	public Object m01(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("aspect 메소드 호출됨 ...");
		Object x = jp.proceed();
		System.out.println("aspect 메소드 끝 ...");
		return x;
	}
//	public void m01(타겟메소드) {
//		타겟메소드();
//		jp.proceed();
//	}	
	
}
