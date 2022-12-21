<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	<%@include file="/WEB-INF/views/include/nav2.jsp" %>
	<!-- ajax 라이브러리 -->
	<script   src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
	<!-- 부트스트랩 -->
	<script   src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	
	
	<!-- summernote css/js-->
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
	<script   src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
	<title>게시판</title>
	</head>

	<body>
	<%@include file="/WEB-INF/views/include/nav.jsp" %>
		<div class="container">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			   수정글작성
			</nav>
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="/FreeBoard/update">
					<input type=hidden name="free_no" value="${update.free_no}" />
					<table>
						<tbody>
							<tr>
								<td>
									<label for="free_board_title">제목</label><input type="text" id="free_board_title" name="free_board_title" value="${update.free_board_title}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="free_board_content">내용</label>
									<textarea id="summernote" name="free_board_content"><c:out value="${update.free_board_content}" /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="member_id" name="member_id" value="${update.member_id}" readonly="readonly"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="free_board_date">작성날짜</label>
									<fmt:formatDate value="${update.free_board_date}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>		
						</tbody>	
						<tr>
							<td><input type="file" name="fileName"></td>
						</tr>		
					</table>
					
					<div>
						
						<button type="submit" class="cancel_btn">취소</button>
					</div>
					 
					<button onClick="location.href='/member/freeboard'" type="submit" class="update_btn">저장</button>
					 <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				 
			</section>
			<hr />
		</div>
	</body>
	         <script>
      function uploadSummernoteImageFile(picfile, el) {    	 
         data = new FormData();         
         data.append('file', picfile)
         
         $.ajax({
            url : "/uploadSummernoteImageFile?${_csrf.parameterName}=${_csrf.token}",
            data : data,
            type : "POST",
            enctype : 'multipart/form-data',
            contentType : false,
            processData : false,
            success : function(result) {
               $(el).summernote('editor.insertImage', result.url);
            },
            error:function(xhr) {
            	alert(xhr.status + ':' + xhr.textStatus)
            }
         });
         
      }
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
   </script>
</html>