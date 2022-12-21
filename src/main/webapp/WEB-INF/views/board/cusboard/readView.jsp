<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>고객센터</title>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp"%>
	<hr/>
	<!-- 게시글 상세출력 시작 -->
		<div class="container">
		<h1>고객센터 게시판</h1>
		<span><a href="/member/customerboard">목록으로 돌아가기</a></span>
		<table class="my-3 border-bottom pb-2">
			<tbody>
				<tr>
					<td>
						<div class="mb-3">
							<label>번호 ${customerBoardDetail.cus_no} / 작성날자 : <fmt:formatDate
									value="${customerBoardDetail.cus_board_date}" pattern="yyyy-MM-dd" /></label><br>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="mb-3">
							<label>작성자</label><br> ${customerBoardDetail.member_id}
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="mb-3">
							<label>제목 : ${customerBoardDetail.cus_board_title}</label><br>
						</div>
				<tr>
					<td>
						<div class="mb-3">
							<label>내용</label><br> ${customerBoardDetail.cus_board_content}
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<sec:authentication property="principal.username" var="user_id" />
		<c:if test="${user_id eq customerBoardDetail.member_id || user_id eq 'admin'}">
		<div>
			<button class="btn btn-primary" type="button"
				onclick="location.href='/member/customerBoardUpdateForm/${customerBoardDetail.cus_no}'">수정</button>
			<button class="btn btn-danger" type="button"
				onclick="location.href='/member/customerBoardDelete/${customerBoardDetail.cus_no}'">삭제</button>
		</div>
		</c:if>
		</div>
	<!-- 게시글 상세출력 끝 -->
	<!-- 댓글 출력 -->
		<hr />
		<div class="container">
			<h2 style="margin: 0px">댓글</h2>
			<h6>(관리자만 작성가능)</h6>
			<table>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성날짜</th>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<sec:authentication property="principal.username" var="user_id" />
					<c:if test="${user_id eq infoBoardDetail.member_id || user_id eq 'admin'}"><th>수정/삭제</th></c:if>
					</sec:authorize>
				</tr>			
			<c:forEach  var="getCustomerReplyList" items="${ getCustomerReplyList }"> 
				<tr>
					<td style="width: 40px">관리자</td>
					<td style="width: 350px">${ getCustomerReplyList.cus_reply_content}</td>
					<td style="width: 40px">
						<fmt:formatDate	value="${ getCustomerReplyList.cus_reply}" pattern="yyyy-MM-dd" /></td>
					<sec:authorize access="hasRole('ROLE_ADMIN')">	
					<td style="width: 40px">
						<a class="btn btn-primary btn-sm" href="/member/customerReplyUpdateForm/${getCustomerReplyList.customer_reply_no}">수정</a>
						<a class="btn btn-danger btn-sm" href="/member/customerReplyDelete/${getCustomerReplyList.customer_reply_no}">삭제</a>
					</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</table>
		</div>
	<!-- 댓글 출력 끝 -->
	<!-- 댓글 등록 -->
	<hr/>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<div class="container">
		<form action="/member/customerboard/replyInsert" method="GET">
			<input type="hidden" name="cus_no" value="${customerBoardDetail.cus_no}">
		
			<label>댓글작성</label>
			<textarea rows="1" cols="100" type="text" name="cus_reply_content"></textarea>
			<button class="btn btn-success">등록</button>
		</form>
	</div>
	</sec:authorize>
	<hr/>
	<!-- 댓글 등록 끝 -->

</body>
</html>