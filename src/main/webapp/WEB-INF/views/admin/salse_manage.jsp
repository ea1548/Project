<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
<meta charset="UTF-8">
<title>매출관리</title>
<style>
#wrap{}
#header{background-dolor : #fff}

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp" %>
	<div id="wrap">
		<header id ="header">
			<div class="container">              
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
		</header><!-- header -->
	</div>
	<div class="select">
        <select name="year">
            <option>년</option>
            <option>2022</option>
            <option>2021</option>
            <option>2020</option> 
        </select>
        <select name="month">
            <option>월</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>11</option>
            <option>12</option>
        </select>
    </div>

        <div class="indicate">
            <div class="name">
               <h2> 상품이름</h2> 
            </div>
            <div class="stock">
                <h2> 수량</h2> 
             </div>
             <div class="year">
                <h2>연도</h2> 
             </div>
             <div class="month">
                <h2>월</h2> 
             </div>
             <div class="accure_price">
                <h2>판매누적금액</h2> 
             </div>
             <div class="charge">
                <h2>배송비</h2> 
             </div>        
                
             
	</div>

<div class="total">
    
    <h2>0000년 00월  총매출 : 0,000,000원</h2>
</div>

</body>
</html>