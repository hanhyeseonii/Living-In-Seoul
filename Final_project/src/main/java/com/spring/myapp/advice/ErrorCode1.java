package com.spring.myapp.advice;

//열거형
//코드와 메시지 관리
public enum ErrorCode1 {
	SUCCESS_ADD("0", "추가 성공"),
	SUCCESS_MODIFY("0", "수정 성공"),
	SUCCESS_REMOVE("0", "삭제 성공");
	
	private String code;
	private String msg;
	//생성자
	private ErrorCode1(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	//게터
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
