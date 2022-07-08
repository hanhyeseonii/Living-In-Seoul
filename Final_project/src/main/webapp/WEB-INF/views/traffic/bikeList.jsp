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
</head>
<body>
	<%@ include file="../header.jsp" %>
	<!-- 비동기 방식 call back 함수 지정하기 -->
	<script type="text/javascript" src="http://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=7v323bqzdx&callback=initMap"></script>
	<%@ include file="./trafficNav.jsp" %>
	<div id="body" class="body">
		<aside class="aside">
			<h6 class="aside_title">따릉이 대여소</h6>
			<div class="traffic_content">
				<div class="aside_profile box">
					<img alt="프로필 사진" class="aside_profile" src="${path}/resources/images/seoulicon.jpg">
				</div>
				<ul class="item_list">
					<li class="aside_item">
						<a class="aside_traffic home" href="${path}/traffic/bikeList">
							<img class="aside_img" alt="" src="${path}/resources/images/aside_home2.png">
							<span class="aside_text">지도홈</span>
						</a>
					</li>
					<li class="aside_item">
						<a href id="bike_rayer">
							<img class="aside_img" alt="" src="${path}/resources/images/aside_bike.png">
							<span class="aside_text">자전거</span>
						</a>
					</li>
					<li class="aside_item">
						<a class="aside_favorite" href id="aside_favorite">
							<img class="aside_img" alt="" src="${path}/resources/images/aside_favorite2.png">
							<span class="aside_text">즐겨찾기</span>
						</a>
					</li>
				</ul>
			</div>
		</aside>
		<div class="favoriteList" id="favoriteList">
			<h6 class="favoriteList_title">즐겨찾는 장소</h6>
			<ul class="favoriteList_ul" id="favoriteList_ul"></ul>
		</div>
		<main>
			<input type="hidden" id="contextPath" value="${path}">
			<input type="hidden" id="stationId" value="ST-976">
			<p>
			<div id="map">
			</div>
		</main>
	</div>
	<%@ include file="../footer.jsp" %>
	
    <script type="text/javascript" src="${path}/resources/js/traffic/bikeList.js"></script>
	
</body>
</html>