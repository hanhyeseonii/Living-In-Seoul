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
<div class="container">
	<%@ include file="../header.jsp" %>
	<hr>
	<h5>관광지 - 서울의 다양한 관광지를 즐겨보세요!</h5>
	
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
	<c:if test="${page.startPage != 1}">
		<a href="${path}/culture/tourism/list?curPage=${page.startPage-1}">이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		<a href="${path}/culture/tourism/list?curPage=${i}">${i}</a> 
	</c:forEach>

	<c:if test="${page.endPage<page.totPage}">
		<a href="${path}/tourism/list?curPage=${page.endPage+1}">다음</a>
	</c:if>
	
	<form action="${path}/culture/tourism/list">
		<select name="findkey">
			<option value="tnum" <c:out value="${page.findkey=='tnum'?'selected':''}"/>>번호</option>
			<option value="tname" <c:out value="${page.findkey=='tname'?'selected':''}"/>>관광지명</option>
			<option value="taddress" <c:out value="${page.findkey=='taddress'?'selected':''}"/>>주소</option>
		</select>
		<input type="text" name="findvalue" value="${page.findvalue}">
		<button>조회</button>
	</form>
</div>	
</body>
</html>