<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/member/login.js"></script>
</head>
<body>
	<br><br><br><br><br><br><br><br>
	<h2 align="center">LIVING IN SEOUL</h2>
	<form id="frmLogin" action="${path}/member/login" method="post">
		<table align="center">
			<tr>
				<th><i class="fas fa-envelope"></i></th>
				<td><input type="email" name="email" id="email" placeholder="이메일" /></td>
			</tr>
			<tr>
				<th><i class="fas fa-key"></i></th>
				<td><input type="password" name="passwd" id="passwd" placeholder="비밀번호" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="button" onclick="location.href='find_email'">find email</button>
				<button type="button" onclick="location.href='find_passwd'">find p/w</button>
				<button id="btnLogin">LOGIN</button><br>
				<a href="${apiURL}"><img alt="" src="${path}/resources/images/NAVER.png" width="62" align="right"></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>