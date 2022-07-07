<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head><link rel="stylesheet" href="${path}/resources/css/traffic.css"></head>


<nav id="stationNav">
	<a href="${path}/traffic/bikeList">대여소조회</a>
	<a href="${path}/traffic/bikeManual">이용방법</a>
	<a href="${path}/traffic/traffic">도로교통상황</a>
	<div class="input_serch">
		<input type="text" id="stationAddress" >
		<button class="serch_btn" id="serch_station">검색</button><br>
	</div>
</nav>
<hr class="nav_hr">