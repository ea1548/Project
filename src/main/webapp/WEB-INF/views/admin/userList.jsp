<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<meta charset="UTF-8">
<title>회원 관리 페이지</title>
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
	
	li {
		list-style: none;
		padding: 6px;
		float: left;
	}
	
	h1,h2{
		text-align: center;
	}
</style>

</head>
<body>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
	<div class="container">
	<h1>유저 관리 페이지</h1>
    <h2>회원  목록</h2>
    <c:forEach var="member" items="${ userList }">
	   <table class="type01">
		<tr>
	    	<th>아이디</th>
	    	<th>닉네임</th>
	    	<th>이메일</th>
	    	<th>전화번호</th>
	    	<th>가입날짜</th>
	    	<th>추방시키기</th>
		</tr>
	  	<tr>
	   		<td>${ member.member_id   }</td>
		    <td>${ member.member_name }</td>
		    <td>${ member.member_email   }</td>
		    <td>${ member.member_phone   }</td>
		    <td>${ member.member_insertdate   }</td>
		    <td>
		    	<a class="btn btn-danger btn-sm" href="/admin/deleteMember?member_id=${ member.member_id }">추방</a>
		    </td>
	  	</tr>
		</table>
    </c:forEach>
    </div>
   	<div class="container">
	  <ul>
	    <c:if test="${pageMaker.prev}">
	    	<li><a href="/admin/userList${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
	    </c:if> 
	
	    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
	    	<li><a href="/admin/userList${pageMaker.makeQuery(idx)}">${idx}</a></li>
	    </c:forEach>
	
	    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
	    	<li><a href="/admin/userList${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
	    </c:if> 
	  </ul> 
	</div>
</body>
</html>