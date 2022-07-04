<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>도로 교통 상황</title>
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=7v323bqzdx"></script>
<link rel="stylesheet" href="${path}/resources/css/traffic.css">
<script type="text/javascript" src="${path}/resources/js/traffic/traffic.js"></script>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h2>도로교통상황</h2>
	<%@ include file="../include/trafficNav.jsp" %>
	<div id="map">
	</div>
	
</body>
</html>