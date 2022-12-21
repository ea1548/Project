<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				location.href = "/board/freeboard/readView?free_no=${read.free_no}"
					   
			})
			
		})
		
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<div>
				
			</div>
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="/board/freeboard/replyFreeUpdate">
					<input type="hidden" id ="free_no" name="free_no" value="${freeBoardReVo.free_no}" />
				    <input type="hidden" id="free_reply_no" name="free_reply_no" value="${freeBoardReVo.free_reply_no}" />
					
					 
					
					<table>
						<tbody>
							<tr>
								<td>
									<label for="free_reply_content">댓글 내용</label><input type="text" id="free_reply_content" name="free_reply_content" value="${selectFreeReply.free_reply_content}"/>
								</td>
							</tr>	
							
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="button" class="cancel_btn">취소</button>
						<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>