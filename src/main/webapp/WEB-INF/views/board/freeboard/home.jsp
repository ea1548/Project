<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<title>Insert title here</title>
<style type="text/css">
   h2 { margin : 20px;  }
   li {list-style: none; float: left; padding: 6px;}
		
</style>
</head>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
<hr />
<h1 style="text-align: center"> 자유게시판 </h1>
<body>
    
<div layout:fragment="content" class="container my-3">
    <table id="freeboard" class="table table-hover">
        <thead class="table-dark">
            <tr class ="text-center">
                <th>번호</th>
                <th style="width: 50%">제목</th>
                <th>글쓴이</th>
                <th>작성일시</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach  var="free_board" items="${ freeBoardList }">
            <tr class="text-center" >
            	<td><c:out value="${free_board.free_no}" /></td>
				<td>
					<a href="/freeboard/readView?free_no=${free_board.free_no}">
					${free_board.free_board_title}</a>
				</td>
                <td> ${ free_board.member_id }</td>
                <td> ${ free_board.free_board_date }</td>
            </tr>
            </c:forEach>
        </tbody>
	</table>
	<a href = "userwrite" class="btn btn-primary" >글쓰기</a>
	</div>
	</body>
	<div class="container my-3">
  <ul>
    <c:if test="${pageMaker.prev}">
    	<li><a href="/member/freeboard${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
    </c:if> 

    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    	<li><a href="/member/freeboard${pageMaker.makeQuery(idx)}">${idx}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    	<li><a href="/member/freeboard${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
  		</ul>
	</div>
</html>