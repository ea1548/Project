<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/login/loginform.css">
<style>
	.error{
		color : red;
		font-size : 12px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<div>
    	<a class="logo" href="/">로고</a>
    </div>
	<div class="signupbox">
  		<h2>회원가입</h2>
  			<form:form id="frm" modelAttribute="memberVo" action="/Write" method="post">
    			<fieldset>
			      <legend>로그인 구역</legend>
			      <div>
				      <form:errors class="error" path="member_id" ></form:errors>
				      <label for="loginid">아이디 : </label>
				      <input type="text" name="member_id" placeholder="아이디를 입력해 주세요">
			      </div>
			      <div>
			      	  <form:errors class="error" path="member_pwd" ></form:errors>
				      <label for="loginpw">비밀번호 : </label>
				      <input type="password" name="member_pwd"  placeholder="비밀번호를 입력해 주세요">
			      </div>
			      <div>
			      	  <form:errors class="error" path="member_name" ></form:errors>
				      <label for="loginid">이름 : </label>
				      <input type="text" name="member_name"  placeholder="이름을 입력해 주세요">
			      </div>
			      <div>
			      	  <form:errors class="error" path="member_email" ></form:errors>
				      <label for="loginid">이메일 : </label>
				      <input type="text" name="member_email"  placeholder="이메일을 입력해 주세요">
			      </div>
			      <div>
			      	  <form:errors class="error" path="member_phone" ></form:errors>
				      <label for="loginid">전화번호 : </label>
				      <input type="text" name="member_phone" placeholder="전화번호를 입력해 주세요">
			      </div>
			  	  <a href="#" onclick="return chk_form()" >회원가입</a>
	    		</fieldset>
	    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	  		</form:form>
		</div>
</body>
<script>
	function chk_form() {
		document.getElementById('frm').submit();
	}
</script>
</html>