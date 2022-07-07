<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/member/sign_up.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h5>SIGN UP</h5>
	<form name="frmSign_up" id="frmSign_up" action="${path}/member/sign_up" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>email</th>
				<td>
				<input type="email" name="email" id="email" placeholder="이메일" />
				<button type="button" onclick="duplCheck(event,'${path}')" class="button_gr">중복확인</button>
				</td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name" id="name" placeholder="이름" /></td>
			</tr>
			<tr>
				<th>password</th>
				<td>
				<input type="password" name="passwd" id="passwd" placeholder="비밀번호" /><br>
				<input type="password" name="againpasswd" id="againpasswd" placeholder="비밀번호확인" />
				<button type="button" onclick="passwdCheck(event)" class="button_gr">일치확인</button>
				</td>
			</tr>
			<tr>
				<th>birthdate</th>
				<td><input type="date" name="birthdate" id="birthdate"/></td>
			</tr>
			<tr>
				<th>address</th>
				<td><input type="text" name="address" id="address" placeholder="예시) 서울시 구로구" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="loginCheck(event)" class="button">sign up</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>