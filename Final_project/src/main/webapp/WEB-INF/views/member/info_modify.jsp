<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/member/info_modify.js"></script>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h5>MY INFORMATION MODIFY</h5>
	<form id="frmInfomodi" action="${path}/member/info_modify" method="post">
		<table>
			<tr>
				<th>email</th>
				<td><input type="email" value="${member.email}"  id="email"  name="email" readonly></td>
			</tr>
			<tr>
				<th>name</th>
				<td>${member.name}</td>
			</tr>
			<tr>
				<th>birthdate</th>
				<td><input type="date" name="birthdate" id="birthdate" value="${member.birthdate}"></td>
			</tr>
			<tr>
				<th>address</th>
				<td><input type="text" name="address" id="address" value="${member.address}"placeholder="주소" ></td>
			</tr>
			<tr>
				<td>
				<button type="button" onclick="modifyCheck(event)" class="button">SAVE</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>