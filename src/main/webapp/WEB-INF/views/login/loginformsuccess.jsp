<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	alert('회원가입에 성공하셨습니다. 로그인페이지로 이동합니다.');
	location.href = "<c:url value='/loginForm' />";
	</script>
</body>
</html>