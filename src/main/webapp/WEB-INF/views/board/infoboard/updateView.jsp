<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<style>
table.type01 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	margin: 20px 10px;
}

table.type01 th {
	text-align: center;
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border: 1px solid #ccc;
}

table.type01 td {
	text-align: center;
	width: 150px;
	padding: 10px;
	vertical-align: top;
	border: 1px solid #ccc;
}
</style>
<%@include file="/WEB-INF/views/include/nav2.jsp"%>

<!-- ajax 라이브러리 -->
<script	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>

<!-- 부트스트랩 -->
<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>

<title>정보공유 게시판 수정</title>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp"%>
	<hr />
	<section id="container">
		<div class="container">
			<h1>정보공유 게시판 수정</h1>
			<form action="/member/infoBoardUpdate" method="POST">
			<input type="hidden" name="info_no" value="${infoBoardDetail.info_no}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<table class="my-3 border-bottom pb-2">
					<tbody>
						<tr>
							<td>
								<div class="mb-3">
									<label>번호 ${infoBoardDetail.info_no} / 작성날자 : 
									<fmt:formatDate
											value="${infoBoardDetail.info_board_date}"
											pattern="yyyy-MM-dd" /></label><br>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="mb-3">
									<label>작성자 : ${infoBoardDetail.member_id}</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="mb-3">
									<label>제목 : 
									<input type="text" name="info_board_title" value="${infoBoardDetail.info_board_title}"></label>
								</div>
							</td>
						<tr>
							<td>
								<div class="mb-3">
									<label>내용</label>								
									<div><textarea id="summernote" name="info_board_content" rows="10" cols="50">${infoBoardDetail.info_board_content}</textarea></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div>
					<button class="btn btn-success" type="submit">수정하기</button>
				</div>
				</form>
		</div>
	</section>
	</body>
		<script>
		$(document).ready(function() {
			$('#summernote').summernote({                                        
				height : 300,
				minHeight : null,
				maxHeight : null,
				focus : true,
				lang : 'ko-KR',
				
				callbacks : {                                                    
					onImageUpload : function(files, editor, welEditable) {       
						for (var i = files.length - 1; i >= 0; i--) {
				            uploadSummernoteImageFile(files[i], this);
						}
					}
				}
			});
		});

		function uploadSummernoteImageFile(file, el) {
			data = new FormData();
			data.append("file", file);
			$.ajax({
				data : data,
				type : "POST",
				url : "/uploadSummernoteImageFile?${_csrf.parameterName}=${_csrf.token}",
				contentType : false,
				enctype : 'multipart/form-data',
				processData : false,
				success : function(data) {
					$(el).summernote('editor.insertImage', data.url);
				}
			});
		}
	</script>
</html>