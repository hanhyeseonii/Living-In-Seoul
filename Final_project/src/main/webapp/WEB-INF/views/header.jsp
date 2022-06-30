<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/member/header.js"></script>
</head>
<body>
	<header>
	<h2>LIVING IN SEOUL</h2>
	<div>
		<input type="hidden" value="${path}" id="contextpath">
		<span id="sessionEmail"><a href="${path}/member/info">${sessionScope.email}</a></span>
		<a href="${path}/member/login" id="aLogin">LOGIN</a>
		<a href="" onclick="logoutCheck(event, '${path}')" id="aLogout">LOGOUT</a>
		<a href="${path}/member/sign_up" id="asign_up" >SIGN UP</a>
	</div>
	</header>
	<nav>
		<div align="right">
			<a href="${path}/member/">HOME</a>
			<a href="${path}/culture/board/">맛집</a>
			<a href="${path}/culture/tourism/">관광지</a>	
			<a href="${path}/weather/weather/">날씨</a>
			<a href="${path}/accident/">안전</a>
			<a href="${path}/traffic/bikeList/">교통</a>
		</div>
	</nav>
	<hr>		
</body>
</html>