<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중식</title>
<link rel="stylesheet" href="/css/food/style.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<style type="text/css">
	li {
	list-style: none;
	padding: 6px;
	float: left;
	}
</style>

</head>
<body>
<%@include file="/WEB-INF/views/include/nav.jsp" %>

   <div class= "kor1">
	  <c:forEach var="chinaImgList"  items="${ chinaImgList }">        
									
			 <div class= "image_wrap"
			  	
        		data-filename="${chinaImgList.fileName}"
				data-productnumber="${chinaImgList.product_number}"
			    data-path="${chinaImgList.uploadPath}" 
			    data-uuid="${chinaImgList.uuid}"
			    
			    >	
			   <img>
			   <a href="/product/china/detail/china_detail?product_number=${chinaImgList.product_number}">${chinaImgList.product_name}</a>
		       <div class = "price">
		       ${chinaImgList.product_price}
		       </div> 
		     </div>
       
       </c:forEach>
  </div>
  
    
     
    <div class="koreanfood">
		<div>
		  <ul class= "korul"style="width: 700px; text-align: center;">
		    <c:if test="${pageMaker.prev}">
		    	<li class= "paging1"><a href="/product/product_china_list${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
		    </c:if> 
		
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    	<li class= "paging2"><a href="/product/product_china_list${pageMaker.makeQuery(idx)}">${idx}</a></li>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    	<li class= "paging3"><a href="/product/product_china_list${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
		    </c:if> 
		  </ul>
		 </div> 
	 </div>
</body>
<script>
	function chk_form() {
		document.getElementById('frm2').submit();
	}
	
</script>

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