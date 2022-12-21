<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
<style>
   table.type01 {
     border-collapse: collapse;
     text-align: left;
     line-height: 1.5;
     margin : 20px 10px;
   }
   table.type01 th {
     text-align : center;
     width: 150px;
     padding: 10px;
     font-weight: bold;
     vertical-align: top;
     border: 1px solid #ccc;
   }
   table.type01 td {
     text-align : center;
     width: 150px;
     padding: 10px;
     vertical-align: top;
     border: 1px solid #ccc;
   }
</style>
	<head>
	<%@include file="/WEB-INF/views/include/nav2.jsp" %>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>자유게시판</title>
	</head>
	<body>
	<%@include file="/WEB-INF/views/include/nav.jsp" %>
		<div>

			<hr />
			
			
			<div class="container">
			<h1> 자유게시판</h1>
			<a href="/member/freeboard">자유게시판 목록</a>
			
					<table class = "my-3 border-bottom pb-2">
						<tbody>
						
							<tr>
							
								<td>
								<div class="mb-3">
									<label for="free_no" class="form-label" class="form-control">글 번호 : ${read.free_no} / 
									작성날짜 : <fmt:formatDate value="${read.free_board_date}" pattern="yyyy-MM-dd"/></label><br>
									
								</div>
								</td>
							
							</tr>
							<tr>
								<td>
								 <div class="mb-3">
									<label for="member_id">작성자 : ${read.member_id}</label><br>
									
								</div>
								</td>
							</tr>
							
							<tr>
								<td>
								 <div class="mb-3">
									<label for="free_board_title">제목 </label><br>
									${read.free_board_title}
								 </div>
								</td>
							</tr>	
							<tr>
								<td>
								 <div class="mb-3">
									<label for="free_board_content">내용 </label><br>
									${read.free_board_content}
								</div>
								</td>
							</tr>
						</tbody>			
					</table>
					<div>
					
					
				</div>
		<sec:authentication property="principal.username" var="user_id" />
		<c:if test="${user_id eq read.member_id || user_id eq 'admin'}">
				<a class="btn btn-primary" href="/updateView?free_no=${ read.free_no }">수정</a>
				<a class="btn btn-danger" href="/delete?free_no=${ read.free_no }">삭제</a>
		</c:if>
				
				</div>
			<hr />
		</div>

		<!-- 댓글 출력 -->
		<hr />
		<div class="container">
			<h2>댓글</h2>
			<table>
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성날짜</th>				
					<th>수정/삭제</th>
					</tr>			
			 <c:forEach items="${freeReplyList}" var="freeReplyList">
				<tr>
					<td style="width: 40px">${freeReplyList.member_id}</td>
					<td style="width: 350px">${freeReplyList.free_reply_content}</td>
					<td style="width: 40px">
					<fmt:formatDate	value="${freeReplyList.free_reply}" pattern="yyyy-MM-dd" /></td>
					<sec:authentication property="principal.username" var="user_id" />
					<c:if test="${user_id eq freeReplyList.member_id || user_id eq 'admin'}">
					<td style="width: 40px">
						<a class="btn btn-primary btn-sm" href="/board/freeboard/replyFreeUpdateView?free_no=${read.free_no}" data-free_reply_no="${selectFreeReply.free_reply_no}">수정</a>
						<a class="btn btn-danger btn-sm" href="/board/freeboard/replyFreeDeleteView?free_reply_no=${freeReplyList.free_reply_no}&free_no=${ freeReplyList.free_no}">삭제</a>
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
		<form id="free_board_re" action="/writeFreeReply" method="post">
			<input type="hidden" id="free_no" name="free_no" value='${ read.free_no}'   >
			
			<input type="hidden" id="free_reply_content  " name="free_reply_content" value="${ readFreeReply.free_reply_content }"  >
			<input type="hidden" id="member_id " name="member_id" value="${ readFreeReply.member_id }"  >
			<div class="container"></div>
		    <h2 class="my-3 border-bottom pb-2">답글등록</h2>
		    <div>
		    <br/>
		   </div>
        <div class="mb-3">
            <label for="free_reply_content" class="form-label">내용</label>
            <textarea name="free_reply_content" class="form-control"></textarea>
        </div>
        <input type="submit" value="저장하기" class="btn btn-primary my-2">
        <a href="#" onClick="history.back()">취소</a>
       
        <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
    
    
    </form>
	</div>
	<hr/>
	<!-- 댓글 등록 끝 -->
	
</body>
</html>