package com.spring.myapp.advice;

public class EnumTest {

	public static void main(String[] args) {
		// 열거형 테스트
		System.out.println(ErrorCode1.SUCCESS_ADD);
		System.out.println(ErrorCode1.SUCCESS_ADD.getCode());
		System.out.println(ErrorCode1.SUCCESS_ADD.getMsg());
		
		System.out.println(ErrorCode1.SUCCESS_REMOVE.getMsg());
	}

}
