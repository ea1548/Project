<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
<title>댓글 수정</title>
</head>
<body>
	<h1>댓글 수정</h1>
	<form action="/admin/customerReplyUpdate" method="GET">
		<input type="hidden" name="cus_no" value="${getReplyOne.cus_no}">
		<input type="hidden" name="customer_reply_no" value="${getReplyOne.customer_reply_no}">
		<label>수정할 내용 : </label>
		<textarea rows="1" cols="100" type="text" name="cus_reply_content">${getReplyOne.cus_reply_content}</textarea>
		<div>
		<button class="btn btn-success">수정하기</button>
		</div>
	</form>
</body>
</html>