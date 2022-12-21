<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<style>
table.type01 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	margin: 20px 10px;
}

table.type01 th {
	text-align: center;
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border: 1px solid #ccc;
}

table.type01 td {
	text-align: center;
	width: 150px;
	padding: 10px;
	vertical-align: top;
	border: 1px solid #ccc;
}
</style>
<%@include file="/WEB-INF/views/include/nav2.jsp"%>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>정보공유 게시판</title>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp"%>
	<hr/>
	<!-- 게시글 상세출력 시작 -->
		<div class="container">
		<h1>정보공유 게시판</h1>
		<span><a href="/member/infoboard">목록으로 돌아가기</a></span>
		<table class="my-3 border-bottom pb-2">
			<tbody>
				<tr>
					<td>
						<div class="mb-3">
							<label>번호 ${infoBoardDetail.info_no} / 작성날자 : <fmt:formatDate
									value="${infoBoardDetail.info_board_date}" pattern="yyyy-MM-dd" /></label><br>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="mb-3">
							<label>제목 : ${infoBoardDetail.info_board_title}</label><br>
						</div>
				<tr>
					<td>
						<div class="mb-3">
							<label>작성자</label><br> ${infoBoardDetail.member_id}
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="mb-3">
							<label>내용</label><br> ${infoBoardDetail.info_board_content}
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div>
		<sec:authentication property="principal.username" var="user_id" />
		<c:if test="${user_id eq infoBoardDetail.member_id || user_id eq 'admin'}">
			<button class="btn btn-primary" type="button"
				onclick="location.href='/member/infoBoardUpdateForm/${infoBoardDetail.info_no}'">수정</button>
			<button class="btn btn-danger" type="button"
		
				onclick="location.href='/member/infoBoardDelete/${infoBoardDetail.info_no}'">삭제</button>
				</c:if>
		</div>
		
		</div>
	<!-- 게시글 상세출력 끝 -->
	<!-- 댓글 출력 -->
		<hr />
		<div class="container">
			<h2>댓글</h2>
			<table>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성날짜</th>
					<th style="width: 40px">수정/삭제</th>
				</tr>			
			<c:forEach  var="getInfoReplyList" items="${ getInfoReplyList }"> 
				<tr>
					<td style="width: 40px">${ getInfoReplyList.member_id}</td>
					<td style="width: 350px">${ getInfoReplyList.info_reply_content}</td>
					<td style="width: 40px">
					
						<fmt:formatDate	value="${ getInfoReplyList.info_reply}" pattern="yyyy-MM-dd" /></td>
					<sec:authentication property="principal.username" var="user_id" />
					<c:if test="${user_id eq getInfoReplyList.member_id || user_id eq 'admin'}">
					<td style="width: 40px">
						<a class="btn btn-primary btn-sm" href="/member/infoReplyUpdateForm/${getInfoReplyList.info_reply_no}">수정</a>
						<a class="btn btn-danger btn-sm" href="/member/infoReplyDelete/${getInfoReplyList.info_reply_no}">삭제</a>
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		</div>
	<!-- 댓글 출력 끝 -->
	<!-- 댓글 등록 -->
	<hr/>
	<div class="container">
		<form action="/member/infoboard/replyInsert" method="GET">
			<input type="hidden" name="info_no" value="${infoBoardDetail.info_no}">
			<input type="hidden" name="member_id" value="${infoBoardDetail.member_id}">
		
			<label>댓글작성</label>
			<textarea rows="1" cols="100" type="text" name="info_reply_content"></textarea>
			<button class="btn btn-success">등록</button>
		</form>
	</div>
	<hr/>
	<!-- 댓글 등록 끝 -->

</body>
</html>