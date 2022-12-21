<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp" %>
	<h1>유저관리페이지</h1>
	<a href="/">홈으로</a>
	
    <h2>회원 목록</h2>
    <c:forEach var="member" items="${ memberList }">
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
		    	<a href="/admin/deleteMember?member_id=${ member.member_id }">꺼져</a>
		    </td>
	  	</tr>
		</table>
    </c:forEach>
</body>
</html>