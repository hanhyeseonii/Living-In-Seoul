<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>따릉이 대여소 조회</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=7v323bqzdx"></script>
    <script type="text/javascript" src="${path}/resources/js/traffic/bikeList.js"></script>
</head>

<body>
	<%@ include file="../header.jsp" %>
	<!-- 비동기 방식 call back 함수 지정하기 -->
	<script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=7v323bqzdx&callback=initMap"></script>
	<h2>따릉이 대여소</h2>
	<hr>
	<nav id="stationNav">
		<a href="">대여소조회</a>
		<a>이용방법</a>
		<a>반납방법</a>
		<a>도로교통상황</a>
	</nav>
	<hr>
	
	<input type="text" name="start" placeholder="출발지 입력"> 
	
	<input type="text" id="goal" name="goal" placeholder="도착지 입력">
	<button >길찾기</button>
	
	<input type="text" id="stationAddress" >
	<button id="serch_station">검색</button><br>
	<input type="hidden" id="contextPath" value="${path}">
	<input type="hidden" id="stationId">
	<p>
	<div id="map">
	</div>
	
</body>
</html>