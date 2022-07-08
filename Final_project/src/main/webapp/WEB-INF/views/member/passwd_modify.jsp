<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/member/passwd_modify.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h5>MY PASSWORD MODIFY</h5>
	<form id="frmPasswdMd" action="${path}/member/passwd_modify" method="post">
		<input type="hidden" value="${email}" name="email">
		<table>
			<tr>
				<th>password</th>
				<td>
				<input type="password" name="passwd" id="passwd" placeholder="새비밀번호" /><br>
				<input type="password" name="againpasswd" id="againpasswd" onchange="savePasswdmd(event)" placeholder="비밀번호확인" />
				<button type="button" onclick="savePasswdmd(event)" class="button_gr">일치확인</button>
				</td>
			</tr>
			<tr>
				<td align="center">
				<button id="savebtn" class="button">SAVE</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>