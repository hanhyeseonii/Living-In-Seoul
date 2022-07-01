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
	<h5>맛집 - 공유할 맛집 정보 글을 올려주세요</h5>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이메일</th>
			<th>조회수</th>
			<th>추천</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="board" items="${blist}">
			<tr>
				<td>${board.bnum}</td>
				<td><a href="${path}/culture/board/detail?bnum=${board.bnum}">${board.subject}</a> </td>
				<td>${board.email}</td>
				<td>${board.readcnt}</td>
				<td>${board.likecnt}</td>
				<td><fmt:formatDate value="${board.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
		</c:forEach>
	
	</table>
	
	
	<a href="${path}/culture/board/add">글쓰기</a>
	<hr>
	<c:if test="${page.startPage != 1}">
		<a href="${path}/culture/board/list?curPage=${page.startPage-1}">이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
		<a href="${path}/culture/board/list?curPage=${i}">${i}</a> 
	</c:forEach>

	<c:if test="${page.endPage<page.totPage}">
		<a href="${path}/culture/board/list?curPage=${page.endPage+1}">다음</a>
	</c:if>
	
	
	
	<form action="${path}/culture/board/list">
		<select name="findkey">
			<option value="bnum" <c:out value="${page.findkey=='bnum'?'selected':''}"/>>번호</option>
			<option value="subject" <c:out value="${page.findkey=='subject'?'selected':''}"/>>제목</option>
			<option value="name" <c:out value="${page.findkey=='name'?'selected':''}"/>>이름</option>
		</select>
		<input type="text" name="findvalue" value="${page.findvalue}">
		<button>조회</button>
	</form>
</div>	
</body>
</html>