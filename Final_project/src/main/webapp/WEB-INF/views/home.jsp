<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/accident/covid.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<h5>홈</h5>
	
	<br><br><br><br><br>
	<!-- 코로나 위젯 -->
	<div>
		<table border="1">
			<tr>
				<th colspan="2">서울 코로나 현황</th>
			</tr>
			<tr>
				<td  width="80">확진자 수</td>
				<td class="covid-cnt" width="60"></td>
			</tr>
			<tr>
				<td>사망자 수</td>
				<td class="death-cnt"></td>
			</tr>
		</table>
	</div>
</body>
</html>