<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 게시글 등록</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<%@include file="/WEB-INF/views/include/nav2.jsp" %>

<!-- ajax 라이브러리 -->
<script	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>

<!-- 부트스트랩 -->
<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
<div class="container">
    <h2 class="my-3 border-bottom pb-2">고객센터 게시글 등록</h2>
    
    <form action="/member/cuswrite" method="post">
     	<div class="mb-3">
            <label for="subject" class="form-label">제목</label>
            <input type="text" name = cus_board_title class="form-control">
        </div>
        <div>
			<select name="category_code">
				<option value="none" selected>=== 선택 ===</option>
	            <option value="01">한식</option>
	            <option value="02">중식</option>
	            <option value="03">일식</option>
	            <option value="04">양식</option>
	            <option value="05">이벤트</option>
			</select>
			<span>분류를 선택해주세요.</span>
		</div>
        <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea id="summernote" name = "cus_board_content" class="form-control" rows="10"></textarea>
            
        </div>
        <input type="submit" value="저장하기" class="btn btn-primary my-2">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>
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
</body>
</html>





