<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	
</body>
</html>