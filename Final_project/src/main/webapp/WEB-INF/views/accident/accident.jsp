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
	<%@include file="../header.jsp"%>
	<h2 style="text-align: center;">교통 돌발 리스트</h2>
	<br>
	<table border="1" style="margin-left:auto; margin-right:auto; text-align: center;">
		<tr>
			<th width="80">번호</th>
			<th width="700">사고 내용</th>
			<th width="200">시간</th>
		</tr>
		<c:forEach var="accidentList" items="${accidentList}">
			<tr>
				<th>${accidentList.accId}</th>
				<th>${accidentList.accInfo}</th>
				<th>${accidentList.regidate}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>