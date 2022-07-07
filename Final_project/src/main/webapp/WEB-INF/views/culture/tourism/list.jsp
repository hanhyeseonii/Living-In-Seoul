<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/includeFile.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../../header.jsp" %>
	<div class="cultureStyle">
		<h5>관광지 - 서울의 다양한 관광지를 즐겨보세요!</h5>
		<br>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>관광지명</th>
				<th>주소</th>
				<th>운영요일</th>
			</tr>
			<c:forEach var="tourism" items="${tlist}">
				<tr>
					<td>${tourism.tnum}</td>
					<td><a href="${path}/culture/tourism/detail?tnum=${tourism.tnum}">${tourism.tname}</a> </td>
					<td>${tourism.taddress}</td>
					<td>${tourism.bsnde}</td>
				</tr>
			</c:forEach>
		
		</table>
		
		<hr>

		
		<form action="${path}/culture/tourism/list">
			<select name="findkey">
				<option value="tnum" <c:out value="${page.findkey=='tnum'?'selected':''}"/>>번호</option>
				<option value="tname" <c:out value="${page.findkey=='tname'?'selected':''}"/>>관광지명</option>
				<option value="taddress" <c:out value="${page.findkey=='taddress'?'selected':''}"/>>주소</option>
			</select>
			<input type="text" name="findvalue" value="${page.findvalue}">
			<button class="button_gr">조회</button>
		</form>
	</div>
</body>
</html>