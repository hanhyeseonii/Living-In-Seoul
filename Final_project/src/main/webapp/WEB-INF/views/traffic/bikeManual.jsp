<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>따릉이 이용방법</title>
		<link rel="stylesheet" href="${path}/resources/css/traffic.css">
	</head>
	<body>
		<%@ include file="../header.jsp" %>
		<%@ include file="./trafficNav.jsp" %>
		<h3 class="traffic_title">대여방법</h3>
		<p class="media">
			<iframe src="https://www.youtube.com/embed/2i2FpMWQBnU" title="YouTube video player" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</p>
		
		<h3 class="traffic_title">반납방법</h3>
		<p class="media">
			<iframe src="https://www.youtube.com/embed/qV8lem9vy8U" title="YouTube video player" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</p>
		<%@ include file="../footer.jsp" %>
	</body>
</html>