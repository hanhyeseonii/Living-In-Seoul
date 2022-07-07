<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/member/header.js"></script>
<style type="text/css">
	a {
		color: black;
		padding: 8px 8px;
	}
	a:hover{text-decoration: none;}
</style>
</head>
<body>
	<header>
	<h3>𝙇𝙞𝙫𝙞𝙣𝙜 𝙄𝙣 𝙎𝙚𝙤𝙪𝙡</h3>
	<div style="margin-right: 150px;">
		<input type="hidden" value="${path}" id="contextpath">
		<span id="sessionEmail"><a href="${path}/member/info">${sessionScope.email}</a></span>
		<a href="${path}/member/login" id="aLogin">LOGIN</a>
		<a href="" onclick="logoutCheck(event, '${path}')" id="aLogout">LOGOUT</a>
		<a href="${path}/member/sign_up" id="asign_up" >SIGN UP</a>
	</div>
	</header>
	<nav>
		<div class="menubar" align="right">
			<a href="${path}/member/">HOME</a>
			<a href="${path}/culture/board/list">맛집</a>
			<a href="${path}/culture/tourism/list">관광지</a>	
			<a href="${path}/weather/weather/">날씨</a>
			<a href="${path}/accident/search">안전</a>
			<a href="${path}/traffic/bikeList/">교통</a>
		</div>
	</nav>
	<hr>		
</body>
</html>