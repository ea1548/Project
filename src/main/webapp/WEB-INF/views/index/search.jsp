<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 확인 페이지</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<link rel="stylesheet" href="/css/index/searchstyle.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
</head>

<body>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
	
	
  	<button class="enter" onclick="location.href='../index/search'"><i class="fa-solid fa-magnifying-glass fa-lg"></i></button>
	<input type="search" class="search" placeholder="상품명을 입력하세요"> 

	<div class= "kor1">
	  <c:forEach var="searchresult"  items="${ searchinfo }">        		
			 <div class= "image_wrap"
			  	
        		data-filename="${searchresult.fileName}"
				data-productnumber="${searchresult.product_number}"
			    data-path="${searchresult.uploadPath}" 
			    data-uuid="${searchresult.uuid}"
			    
			    >	
			   <img>
			   <a href="/product/korea/detail/korea_detail?product_number=${searchresult.product_number}">${searchresult.product_name}</a>
		       <div class = "price">
		       ${searchresult.product_price}
		       </div> 
		     </div>
       </c:forEach>
  </div>
	
	
</body>



<script>

$(document).ready(function(){
	
	
	/* 이미지 삽입 */
	$(".image_wrap").each(function(i, obj){
		
		const bobj = $(obj);
		
		if(bobj.data("productnumber")){
			const uploadPath = bobj.data("path");
			const uuid = bobj.data("uuid");
			const fileName = bobj.data("filename");
			
			const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
			
			$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
			
		} else {
			
			$(this).find("img").attr('src', '/resources/image/nothing.png');
			
		}

		
	});		
	
});	



</script>


	
</html>