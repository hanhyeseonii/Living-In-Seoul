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
<script type="text/javascript" src="${path}/resources/js/culture/boardReply.js"></script>
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
	<%@ include file="../../header.jsp" %>
	<div class="cultureStyle">
		<h5>맛집 - 공유할 맛집 정보 글을 올려주세요</h5>
		<br>
		<table border="1">
			<tr>
				<th>번호</th>
				<td id="bnum">${board.bnum}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><fmt:formatDate value="${board.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<c:forEach var="boardFile" items="${bflist}">
						${boardFile.filename} <br>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.content}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.readcnt}</td>
			</tr>
			<tr>
				<!-- 좋아요 -->
				<th><i class="fas fa-thumbs-up" id="like"></i></th>
				<td id="likecnt">${board.likecnt}</td>
			</tr>	
			<tr>
				<!-- 싫어요 -->
				<th><i class="fas fa-thumbs-down" id="dislike"></i></th>
				<td id="dislikecnt">${board.dislikecnt}</td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location.href='${path}/culture/board/modify?bnum=${board.bnum}'" class="button_gr">수정</button>
					<button id="replyAddShow" class="button_gr">댓글</button>
					<button onclick="removeCheck('${path}', ${board.bnum})" class="button_gr">삭제</button>
					<button onclick="location.href='${path}/culture/board/list'" class="button_gr">리스트</button>
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
						<input type="email" class="form-control ml-2" id="replyemail" value="${sessionScope.email}" readonly>
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