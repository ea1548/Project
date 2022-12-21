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
	<form action="/member/infoReplyUpdate" method="GET">
		<input type="hidden" name="info_no" value="${getReplyOne.info_no}">
		<input type="hidden" name="info_reply_no" value="${getReplyOne.info_reply_no}">
		<label>수정할 내용 : </label>
		<textarea rows="1" cols="100" type="text" name="info_reply_content">${getReplyOne.info_reply_content}</textarea>
		<div>
		<button class="btn btn-success">수정하기</button>
		</div>
	</form>
</body>
</html>