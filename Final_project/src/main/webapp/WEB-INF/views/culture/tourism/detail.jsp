<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/culture/fileImage.js"></script>
<!-- 핸들마 탬플릿 cdn연결 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/culture/boardDetail.js"></script>
<script type="text/javascript" src="${path}/resources/js/culture/tourismReply.js"></script>
<!-- 댓글리스트 탬플릿 소스 -->
<script type="text/x-handlebars-template" id="template_source">
	{{#each .}}
		<div class="divReply" id='reply{{rnum}}'>
			{{#levelSpace relevel}} <!--헬퍼작성:levelSpace(헬퍼의 이름) -->
			{{/levelSpace}}
			<div >
				<span style="display:none;">{{rnum}}</span>
				<span style="display:none;" id="restep{{rnum}}">{{restep}}</span> 
				<span style="display:none;" id="relevel{{rnum}}">{{relevel}}</span> <br>

				이메일 : <span> {{email}}</span> <br>
				내용 : <pre id='content{{rnum}}'>{{content}}</pre> <br>
				<button class="reReplyAddShow" value="{{rnum}}">댓글</button>
				<button class="reReplyModify" value="{{rnum}}">수정</button>
				<button class="reReplyRemove" value="{{rnum}}">삭제</button>
			</div>
		</div>
		<hr>
	{{/each}}
</script>

</head>
<body>
<div class="container">
	<%@ include file="../header.jsp" %>
	<hr>
	<h5>관광지 - 서울의 다양한 관광지를 즐겨보세요!</h5>
	
	<table>
		<tr>
			<th>관광지명</th>
			<td>${tourism.tname}</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<img src="${path}/resources/images/${tourism.tnum}.jpg">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${tourism.taddress}</td>
		</tr>
		<tr>
			<th>신주소</th>
			<td>${tourism.taddress_new}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${tourism.phone}</td>
		</tr>
		<tr>
			<th>웹사이트</th>
			<td><a href="${tourism.site}">${tourism.site}</a> </td>
		</tr>
		<tr>
			<th>운영시간</th>
			<td>${tourism.use_time}</td>
		</tr>
		<tr>
			<th>운영요일</th>
			<td>${tourism.bsnde}</td>
		</tr>
		<tr>
			<th>휴무일</th>
			<td>${tourism.rstde}</td>
		</tr>
		<tr>
			<th>교통정보</th>
			<td>${tourism.subway_info}</td>
		</tr>
		<tr>
			<th>태그</th>
			<td>${tourism.tag}</td>
		</tr>
		<tr>
			<th>장애인편의시설</th>
			<td>${tourism.BF_DESC}</td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="replyAddShow">댓글</button>
				<button onclick="location.href='${path}/culture/tourism/list'">리스트</button>
			</td>
		</tr>
	</table>
	<hr id="hr">
	<!-- 댓글추가 -->
	<div class="card mb-2" id="divReplyAdd">
		<div class="card-header bg-light">
		        <i class="fa fa-comment fa"></i> REPLY 추가
		        <input type="hidden" id="restep" size="3">
		        <input type="hidden" id="relevel" size="3">
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
			    <li class="list-group-item">
				<div class="form-inline mb-2">
					<label for="replyemail"><i class="fas fa-envelope"></i></label>
					<input type="email" class="form-control ml-2" id="replyemail" value="${sessionScope.tname}" readonly>
				</div>
				<textarea class="form-control" id="replycontent" rows="3"></textarea>
				<button type="button" class="btn btn-dark mt-3" id="replyAdd">추가</button>
				<button type="button" class="btn btn-dark mt-3" id="replyCancel">취소</button>
			    </li>
			</ul>
		</div>
	</div>	
	
	<!-- 댓글수정 -->
	
	<div class="card mb-2" id="divReplyModify">
		<div class="card-header bg-light">
			<i class="fa fa-comment fa"></i> REPLY 수정
			<input type="hidden" id="replyrnumModify">
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
			    <li class="list-group-item">
				<textarea class="form-control" id="replycontentModify" rows="3"></textarea>
				<button type="button" class="btn btn-dark mt-3" id="replyModify">저장</button>
				<button type="button" class="btn btn-dark mt-3" id="replyModifyCancel">취소</button>
			    </li>
			</ul>
		</div>
	</div>

	
	
	<!-- 댓글리스트 -->
	<div id="divReplyList"></div>
</div>	
</body>
</html>