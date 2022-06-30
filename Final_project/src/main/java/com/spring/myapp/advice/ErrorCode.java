package com.spring.myapp.advice;

public enum ErrorCode {
	//0:성공, 1:실패
	//로그인
	ERROR_NONEXIST_EMAIL(1,"이메일이 없습니다."),
	ERROR_NONMATCH_PASSWD(1,"비밀번호가 일치하지 않습니다."),
	LOGIN_SUCCESS(0,"환영합니다."),
	//네이버로그인
	ERROR_NONSIMPLE(1,"네이버 간편가입 회원이 아닙니다."),
	SUCCESS_SIMPLE_LOGIN(0,"네이버 간편가입 로그인 성공"),
	SUCCESS_SIMPLE_SIGNUP(0,"네이버 간편가입이 완료되었습니다."),
	ERROR_NAVERAUTH(1,"네이버 인증이 유효하지 않습니다."),
	//탈퇴
	ERROR_NONINSERT_WDRS(1,"탈퇴사유를 입력해주세요."),
	WDRAW_SUCCESS(0,"탈퇴되었습니다."),
	//회원가입
	ERROR_EXIST_EMAIL(1,"이미 등록된 이메일 입니다."),
	SIGNUP_SUCESS(0,"가입이 완료되었습니다."),
	//정보수정
	SUCCESS_INFOMODIFY(0,"정보 수정이 완료되었습니다."),
	//이메일 중복확인
	SUCCESS_NONEXIST_EMAIL(0,"사용가능한 이메일"),
	ERROR_ALREADY_EMAIL(1,"이미 사용되고있는 이메일입니다."),
	//비밀번호 찾기
	SUCCESS_MATCH_PWINFO(0,"비밀번호 변경으로 이동합니다."),
	ERROR_NONMATCH_PWINFO(1,"일치하는 회원이 없습니다."),
	SUCCESS_PWMODIFY(0,"비밀번호 수정이 완료되었습니다.");

	
	private int code;
	private String msg;

	//생성자
	private ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	//게터
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
