package com.spring.myapp.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//aop구현
@Component //스프링이 자동객체 생성
@Aspect
public class LoggingAdvice {
	
	//매개변수를 출력 
	//execution : 반환형 패키지명.클래스명.메소드명(..)
	//포인트컷 작성
	@Before("execution(* com.spring.myapp.controller.*.*(..))")
	public void beforeLog(JoinPoint jp) {
		System.out.println("매개변수:"+jp.getSignature().toShortString() + Arrays.toString(jp.getArgs()));
	}
	
	//리턴값 출력
	//Object obj : 리턴 오브젝트
	@AfterReturning(pointcut="execution(* com.spring.myapp.repository.*.*(..))", returning = "obj")
	public void afterLog(JoinPoint jp, Object obj) {
		if (obj != null) {
			System.out.println("--------------------------------------------");
			System.out.println("리턴값:" + jp.getSignature().toShortString());
			System.out.println(obj); 
			System.out.println("--------------------------------------------");
		}
	}
	
//	//메소드 실행 소요시간 체크
	//@Around("execution(* com.spring.myapp.service.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//시작시간
		long startTime = System.currentTimeMillis(); // 시스템의 시간을 1/1000초 단위로 반환
		
		System.out.println(pjp.getSignature().toShortString()); //실행되는 메소드의 이름
		//result:실행메소드가 반환하는 값
		Object result = pjp.proceed(); //실행메소드 객체
		
		//끝시간
		long endTime = System.currentTimeMillis();
		
		//소요시간
		System.out.println("소요시간:" + (endTime-startTime));

		//실행메소드가 반환하는 값을 호출한 메소드에 전달
		return result;
		
	}
	
	
	
}
