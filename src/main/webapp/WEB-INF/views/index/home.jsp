<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>밀키트 쇼핑몰</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
	

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery/2.5.0/css/lightgallery.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery/2.5.0/css/lg-thumbnail.min.css"/>
<link rel="stylesheet" href="/css/index/style.css">




<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<style>
	ul,li{
		list-style: none;
		
	}
	
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: blue; text-decoration: underline;}
</style>

</head>
	<!-- 네비바 -->
	<%@include file="/WEB-INF/views/include/nav.jsp" %>
	<!-- 네비바 끝 -->

<form action="/index/search" method="GET">
	<input type="text" class="search"  name="keyword" placeholder="상품명을 입력하세요" >
    <i><button class="enter">검색</button></i>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
	
 
 
  <div class="slider">
  		<div><a><img class="ad" src="img/ad.jpg"></a></div>
  		<div><a><img class="ad" src="img/kit.jpg"></a></div>
  		<div><a><img class="ad" src="img/kit2.jpg"></a></div>
  </div>
  
		<i class="fa-solid fa-chevron-left"></i>
  		<i class="fa-solid fa-chevron-right"></i>
 

  

   
    
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lightgallery/2.5.0/lightgallery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lightgallery/2.5.0/plugins/thumbnail/lg-thumbnail.min.js"></script>

<script>

$(document).ready(function(){
  $('.slider').slick({
	 
				// 옆으로 이동하는 화살표 표시 여부
		dots : false, 		// 스크롤바 아래 점으로 페이지네이션 여부
		autoplay : true
  });
});
		
</script>

</body>



 
    <h1>저렴한 가성비 밀키트 TOP 3</h1>
    	<div class="mealkit">
        <c:forEach var="mainImgList"  items="${ mainImgList }" begin="0" end="2">						
			<ul>
			   <li>
				   <div class= "image_wrap"
	        		data-filename="${mainImgList.fileName}"
					data-productnumber="${mainImgList.product_number}"
				  	data-path="${mainImgList.uploadPath}"
				  	data-uuid="${mainImgList.uuid}">	
				   <a href="/product/eu/detail/eu_detail?product_number=${mainImgList.product_number}"><img></a>
				   <div><a href="/product/eu/detail/eu_detail?product_number=${mainImgList.product_number}">${mainImgList.product_name}</a></div>
			       <div class = "price">${mainImgList.product_price}</div> 
			       </div>
		       </li>
			</ul>
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