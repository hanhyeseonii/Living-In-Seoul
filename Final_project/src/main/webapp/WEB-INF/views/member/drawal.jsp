<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<h5>MEMBERSHIP WITHDRAWAL</h5>
	<form action="${path}/member/drawal" method="post">
		<table>
			<tr>
				<th>email</th>
				<td><input name="email" value="${email}"></td>
			</tr>
			<tr>
				<th>withdrawal reason</th>
				<td><textarea name="wdrawrs" id="wdrawrs" rows="5" cols="25" placeholder="탈퇴사유" >${wdraw.wdrawrs}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button class="button">회원탈퇴</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>