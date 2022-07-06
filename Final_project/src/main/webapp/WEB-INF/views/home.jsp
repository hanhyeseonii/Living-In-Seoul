<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/accident/covid.js"></script>
<script type="text/javascript" src="${path}/resources/js/accident/accidentHome.js"></script>
<script type="text/javascript" src="${path}/resources/js/weather/weatherHome.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
</head>
<body>
	<%@ include file="./header.jsp"%>
	
	<div id="full-width">
		<div class="mainImage" align="center">
			<img alt="" src="${path}/resources/images/1.jpg" >
			<div class="title" id="title">𝙇𝙞𝙫𝙞𝙣𝙜 𝙄𝙣 𝙎𝙚𝙤𝙪𝙡</div>
		</div>
		<hr>
		<div class="banner">
			[날씨] 서울시&nbsp;<div class="weather-text"></div>
			│[코로나] 확진자 수&nbsp;<div class="covid-cnt"></div>
			&nbsp;사망자 수&nbsp;<div class="death-cnt"></div>
		</div>
		<div class="banner"><h5 style="font-weight: bold;">돌발 정보</h5>&nbsp;<div style="text-decoration: underline;" class="accident-text"></div></div>
		<hr>
		<div class="menu">
			<div class="menuCard">
				<a href="${path}/culture/tourism/"><img alt="" src="${path}/resources/images/hanRiver.jpg"  width='350px' height='250px'></a>
			</div>
			<div class="menuCard">
				<a href="${path}/culture/board/"><img alt="" src="${path}/resources/images/food.jpg"  width='350px' height='250px'></a>
			</div>
			<div class="menuCard">
				<a href="${path}/traffic/bikeList/"><img alt="" src="${path}/resources/images/bike.jpg"  width='350px' height='250px'></a>
			</div>
		</div>
		<div style="display: flex;">
			<div style="margin-left: 140px;">
				인기 게시물<br>
				게시글1<br>
				게시글2<br>
				게시글3<br>
			</div>
			<div style="margin-left: 600px">
				최근 게시물<br>
				게시글1<br>
				게시글2<br>
				게시글3<br>
			</div>
		</div>
	</div>
	<%@ include file="./footer.jsp"%>
</body>

</html>