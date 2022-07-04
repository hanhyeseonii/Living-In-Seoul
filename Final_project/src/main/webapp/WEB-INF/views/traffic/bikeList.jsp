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
    <!-- JQuery AutoComplite 라이브러리에 필요한 css,js -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    
    <!-- 네이버 맵 호출 cdn -->
    <script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=7v323bqzdx"></script>
    <link rel="stylesheet" href="${path}/resources/css/traffic.css">
    <script type="text/javascript" src="${path}/resources/js/traffic/bikeList.js"></script>
</head>

<body>
	<%@ include file="../header.jsp" %>
	<!-- 비동기 방식 call back 함수 지정하기 -->
	<script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=7v323bqzdx&callback=initMap"></script>
	<%@ include file="../include/trafficNav.jsp" %>
	
	<h2>따릉이 대여소</h2>
	<div class="input_serch">
		<input type="text" id="stationAddress" >
		<button id="serch_station">검색</button><br>
	</div>
	<input type="hidden" id="contextPath" value="${path}">
	<input type="hidden" id="stationId" value="ST-976">
	<button id="bicycle">자전거</button>
	<p>
	<div id="map">
		
	</div>
</body>
</html>