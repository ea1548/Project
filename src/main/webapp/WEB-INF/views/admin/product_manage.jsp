<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<meta charset="UTF-8">
<title>상품목록/상품관리</title>
<style>
	ul, li{ 
		list-style: none;
	 }

	tr,td{
		text-align: center;
	}
	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp" %>
	<div class="container">
		<header id ="header">
			<div>              
				    <div class="header clearfix">
					    <ul class="list1 clearfix">
						    <li class="home"><a href="/">홈으로</a></li>					
					    </ul>
					        <ul class="list2">
						        <li class="log">
                                <a href="/admin/admin_main">관리자페이지</a></li>                            
                            </ul>
                    </div>                   
			</div>
		</header>
	</div>
	<div class="container">
	<table>
       <tr>
       </tr>
       <tr>
         <td>상품번호</td>
         <td>상품이름</td>
         <td>상품분류</td>
         <td>상품가격</td>
         <td>상품재고</td>
         <td>상품수정</td>
         <td>삭제하기</td>                
       </tr>     
        
       <c:forEach var="savedproductlist"  items="${ list }">
        <tr>
		 <td>${savedproductlist.product_number}</td>
		 <td>${savedproductlist.product_name}</td>
		 <td>${savedproductlist.category_code}</td>
		 <td>${savedproductlist.product_price}</td>
		 <td>${savedproductlist.product_stock}</td>  
		 <td>
		 <a href="/admin/modifyproduct/${savedproductlist.product_number}">수정</a>
		 </td>		 
		 <td>
		  <a href="/admin/Product/deleteProduct?product_number=${savedproductlist.product_number}">삭제</a>		  
		 </td>       
        </tr>
        
       </c:forEach>
       
     </table>
     </div>
	
           

 <div class="container" id="new_product">
    <div class="new_btn">
        <ul>
            <li class="new_btn"><a href="/admin/newproduct_manage">상품추가</a></li>           
        </ul>
    </div>
  </div>
   

 </div>
<script >
/* 수정 페이지 이동 */
$("#modifyBtn").on("click", function(e){
	e.preventDefault();
	let addInput = '<input type="hidden" name="product_number" value="${goodsInfo.product_number}">';
	$("#moveForm").append(addInput);
	$("#moveForm").attr("action", "/admin/Modifyproduct");
	$("#moveForm").submit();
});	

</script>
</body>
</html>