<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/login/style.css">
</head>
<body>
	<div class="loginbox">
  		<form id="frm" action="/login" method="POST">
  		  <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
   			 <font color="red">
       		 <p>아이디와 비밀번호를 체크해주세요.</p>
       		 
      		 <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
  		  </font>
		  </c:if>
		  <h1 style="text-align: center">로그인</h1> 
	      <label>아이디</label>
	      <input type="text" name="username" placeholder="아이디를 입력하세요" />
	      <label>비밀번호</label>
	      <input type="password" name="password" placeholder="비밀번호를 입력하세요" />
	      <a href="#" onclick="return chk_form()" >로그인</a>
	      <a href="loginForm2">회원가입</a>
	      
	      <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
	  	</form>
	</div>
</body>
<script>
function chk_form() {
document.getElementById('frm').submit();
}
</script>
</html>