<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/sign_up.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h5>SIGN UP</h5>
	<form id="frmSign_up" action="${path}/member/sign_up" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>email</th>
				<td>
				<input type="email" name="email" id="email"/>
				<button type="button" onclick="duplCheck(event,'${path}')">중복확인</button>
				</td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name" id="name"/></td>
			</tr>
			<tr>
				<th>password</th>
				<td>
				<input type="password" name="passwd" id="passwd"/><br>
				<input type="password" name="againpasswd" id="againpasswd"/>
				<button type="button" onclick="passwdCheck(event)">일치확인</button>
				</td>
			</tr>
			<tr>
				<th>birthdate</th>
				<td><input type="date" name="birthdate" id="birthdate"/></td>
			</tr>
			<tr>
				<th>address</th>
				<td><input type="text" name="address" id="address"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>sign up</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>