<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<title>고객센터</title>
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
</head>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
<hr />
<h1 style="text-align: center">고객센터</h1>
<body>
    
<div class="container my-3">
    <table class="table table-hover">
        <thead class="table-dark">
            <tr class ="text-center">
                <th>번호</th>
                <th style="width: 50%">제목</th>
                <th>글쓴이</th>
                <th>분류</th>
                <th>작성일시</th>
            </tr>
        </thead>
         <tbody>
             <c:forEach  var="customerBoardList" items="${ customerBoardList }"> 
             <tr class="text-center" >
            	<td>${customerBoardList.cus_no}</td>
				<td>
					<a href="/member/customerboard/${customerBoardList.cus_no}">
				${customerBoardList.cus_board_title}</a>
				</td>             
                <td>${customerBoardList.member_id}</td>
                <c:choose> 
				    <c:when test="${customerBoardList.category_code eq '01'}">
				        <td>한식</td>
				    </c:when>
				    <c:when test="${customerBoardList.category_code eq '02'}">
				        <td>중식</td>
				    </c:when>
				    <c:when test="${customerBoardList.category_code eq '03'}">
				        <td>일식</td>
				    </c:when>
				    <c:when test="${customerBoardList.category_code eq '04'}">
				        <td>양식</td>
				    </c:when>
				    <c:when test="${customerBoardList.category_code eq '05'}">
				        <td>이벤트</td>
				    </c:when>
				</c:choose>
                <td><fmt:formatDate value="${customerBoardList.cus_board_date}" pattern="yyyy-MM-dd"/></td>
            </tr>  
            </c:forEach>  
        </tbody>	
	</table>
	<a href = "/member/customerWriteForm" class="btn btn-primary" >글쓰기</a>
	</div>
	<div  class="container">
	 <ul>
	    <c:if test="${pageMaker.prev}">
	    	<li><a href="/member/customerboard${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
	    </c:if> 
	
	    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
	    	<li><a href="/member/customerboard${pageMaker.makeQuery(idx)}">${idx}</a></li>
	    </c:forEach>
	
	    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
	    	<li><a href="/member/customerboard${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
	    </c:if> 
	  </ul> 
</div>
	</body>  	
</html>