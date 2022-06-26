<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/weather/weather.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript">
	
</script>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">

</head>
<body>
<%@include file="../header.jsp"%>
	<table border="1">
		<tr>
			<th></th>
			<th>날씨 정보</th>
		</tr>
		<tr>
			<th>
				<div class="box">
					<img id ="seoul" src="../../resources/images/Seoul.png">
					<div class="text" id="jonglo">종로구</div>
					<div class="text" id="joong">중구</div>
					<div class="text" id="yongsan">용산구</div>
					<div class="text" id="seongdong">성동구</div>
					<div class="text" id="gwangjin">광진구</div>
					<div class="text" id="dongdaemoon">동대문구</div>
					<div class="text" id="joonglang">중랑구</div>
					<div class="text" id="seongbook">성북구</div>
					<div class="text" id="gangbook">강북구</div>
					<div class="text" id="dobong">도봉구</div>
					<div class="text" id="nowon">노원구</div>
					<div class="text" id="eunpyeong">은평구</div>
					<div class="text" id="seodaemoon">서대문구</div>
					<div class="text" id="mapo">마포구</div>
					<div class="text" id="yangcheon">양천구</div>
					<div class="text" id="gangseo">강서구</div>
					<div class="text" id="guro">구로구</div>
					<div class="text" id="geumcheon">금천구</div>
					<div class="text" id="yeongdeungpo">영등포구</div>
					<div class="text" id="dongjak">동작구</div>
					<div class="text" id="gwanak">관악구</div>
					<div class="text" id="seocho">서초구</div>
					<div class="text" id="gangnam">강남구</div>
					<div class="text" id="songpa">송파구</div>
					<div class="text" id="gangdong">강동구</div>
					
				</div>
				
				

			</th>
			<th> 
				<div id="weatherDetail">
					<h2 class="weather-region"></h2><br>
					<h4 class="weather-state-text"></h4>					
					
					<ul>
						<li class="weather-temp"></li>
						<li class="weather-rainChance"></li>
						<li id="RN1"></li>
						<li class="weather-humid"></li>
						<li class="weather-windSpeed"></li>
					</ul>
				</div> 
			</th>
		</tr>
	</table>
	
</body>
</html>