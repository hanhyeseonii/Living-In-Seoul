<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h5>FIND PASSWORD</h5>
	<form action="${path}/member/find_passwd" method="post">
		<table>
			<tr>
				<th>email</th>
				<td><input type="email" name="email" id="email" placeholder="이메일" /></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name" id="name" placeholder="이름" /></td>
			</tr>
			<tr>
				<th>birthdate</th>
				<td><input type="date" name="birthdate" id="birthdate" placeholder="생년월일" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="button">find</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>