<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<title>관리자 페이지</title>
<style>
	h2{
	 	text-align: center;
	 	position: relative;
	 	top: 50px;
	 	font-size: 30px;
	 }
	 
	.management a{
		    width: 250px; 
		    margin: 0px 80px;
		    border: none;
		    background-color: #1673ea;
		    color: #fff; 
		    font-size: 30px; 
		    font-weight: bold;
		    float: left;
		    text-align: center;
		    line-height: 250px;
		    position: relative;
		    left: 580px;
		    top: 200px;
		    white-space: nowrap;
		    table-layout:fixed
		}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp" %>

			<div class="management">                                
                    <div class="admin">
                        <h2>관리자페이지</h2>
                    </div>
					<div class="admin_main">
					    <a class="member_manage" href="/admin/userList" >회원관리</a>
						<a class="product_manage" href="/admin/product_manage" >상품관리</a>
					</div>
			</div>
	

</body>
</html>