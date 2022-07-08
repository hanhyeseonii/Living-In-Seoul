<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/culture/fileImage.js"></script>
<!-- 핸들마 탬플릿 cdn연결 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>

</head>
<body>
	<%@ include file="../../header.jsp" %>
	<div class="cultureStyle">
		<h5>관광지 - 서울의 다양한 관광지를 즐겨보세요!</h5>
		<br>
		<table>
			<tr>
				<th>관광지명</th>
				<td>${tourism.tname}</td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<img src="${path}/resources/images/culture/${tourism.tnum}.jpg" width="600" height="400">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${tourism.taddress}</td>
			</tr>
			<tr>
				<th>신주소</th>
				<td>${tourism.taddress_new}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${tourism.phone}</td>
			</tr>
			<tr>
				<th>웹사이트</th>
				<td><a href="${tourism.site}">${tourism.site}</a> </td>
			</tr>
			<tr>
				<th>운영시간</th>
				<td>${tourism.use_time}</td>
			</tr>
			<tr>
				<th>운영요일</th>
				<td>${tourism.bsnde}</td>
			</tr>
			<tr>
				<th>휴무일</th>
				<td>${tourism.rstde}</td>
			</tr>
			<tr>
				<th>교통정보</th>
				<td>${tourism.subway_info}</td>
			</tr>
			<tr>
				<th>태그</th>
				<td>${tourism.tag}</td>
			</tr>
			<tr>
				<th>장애인편의시설</th>
				<td>${tourism.BF_DESC}</td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location.href='${path}/culture/tourism/list'" class="button_gr">리스트</button>
				</td>
			</tr>
		</table>
		<hr id="hr">
		
	</div>
</body>
</html>