<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/accident/covid.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript">
$(function(){
    $('.bxslider').bxSlider({
        auto: true,
        autoControls: true,
        stopAutoOnClick: true,
        pager: true,
        slideWidth: 600
    });

});
</script>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<div style="display:inline;">코로나</div>
	<div style="display:inline;">날씨</div>
	<br>
	<div class="bxslider" align="center">
		<img alt="" src="${path}/resources/images/hanRiver.jpg" >
		<img alt="" src="${path}/resources/images/bike.jpg" >
		<img alt="" src="${path}/resources/images/food.jpg" >
	</div>
	<br><br>
	<div style="display:inline;">인기 게시물</div>
	<div style="display:inline;">최근 게시물</div>
	
	<br><br><br><br><br>
	<!-- 코로나 위젯 -->
	<div>
		<table border="1">
			<tr>
				<th colspan="2">서울 코로나 현황</th>
			</tr>
			<tr>
				<td  width="80">확진자 수</td>
				<td class="covid-cnt" width="60"></td>
			</tr>
			<tr>
				<td>사망자 수</td>
				<td class="death-cnt"></td>
			</tr>
		</table>
	</div>
</body>
</html>