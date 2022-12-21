<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="css/cart/style.css">
</head>
<body>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
<div class="container">
	<form action="cart" method="POST">
    <table class="cart__list">
    	<h1>장바구니</h1>
                    <tr>
                        <th>상품이름</th>
                        <th>수량</th>
                        <th>상품금액</th>
                        <th>총금액</th>                        
                        <th>배송비</th>
                        <th>삭제</th>
                    </tr>
                    <c:forEach  var="cartListDifferent" items="${ cartListDifferent }">
                    <tr>
                       <td>${cartListDifferent.product_name}</td>
                       <td>${cartListDifferent.product_stock}</td>
                       <td>${cartListDifferent.product_price}</td>
                       <td>${cartListDifferent.product_price*cartListDifferent.product_stock}</td>
                       <td>${cartListDifferent.add_charge}</td>
                       <td><a class="btn btn-danger btn-sm" href="/CartDelete?cart_no=${cartListDifferent.cart_no}">삭제</a></td>
                    </tr>
                    </c:forEach>
   	 	</table>
   	 	<c:if test="${cartSum != null}">
				<div>총액 : ${cartSum}원</div>
				</c:if>


   	 </form>	
    
    <div>
            <button class="back_page" onclick="javascript:history.back();">이전 페이지로 이동</button>
    </div>
    </div>
    	
    <script type="text/javascript">
    	function cartOrder(){
    	var result = confirm("${cartSum}원을 결제하시겠습니까?")
    		if(result){
    			alert("결제가 완료되었습니다.");
    			location.href = "<c:url value='/DeleteCart' />";
    		} else {
    			alert("결제가 취소되었습니다.");
    		}
    	}
    </script>
    	<button class="purchase" onclick="cartOrder()" >결제하기</button>
    
</body>
</html>