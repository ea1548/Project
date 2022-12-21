<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한식 상세 페이지</title>
<link rel="stylesheet" href="css/product/korea/detail.css">
<%@include file="/WEB-INF/views/include/nav2.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
	<div class="info">
		<img src="../images(kor)/돼지국밥.jpg">
		<ul>
			<p>상품명	:	돼지국밥</p>
			<p>가격		:	7,000원</p> 
			<p>수량선택
        			<select>
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
			        </select>
			     <p><button><a href="../loginpage/login.html">장바구니 담기</a></button>
			     <button>결제하기</button>
			</p>
			<table>
				<tr>
					<th>구성품</th>
					<td width="50px">1. 고기 + 인삼 120g&nbsp;
					2. 육수 600g&nbsp;
					3. 양념장 15g&nbsp;
					4. 새우젓 15g</td>
				</tr>
				<tr>
					<th>조리방법</th>
					<td>1. 냉동된 제품을 포장상태로 냉장해동 또는 유수해동합니다.<br>
					2-1. 해동된 제품을 개봉한 뒤 냄비에 부어 중불에 5분가량 끓여드세요.<br>
					2-2. 해동된 제품을 개봉한 뒤 내용물을 전자레인지 용기에 넣고 3~4분간 충분히 데워드세요.</td>
				</tr>
				<tr>
					<th>유통기한</th>
					<td>제조일로부터 6개월 이내 섭취</td>
				</tr>
				<tr>
					<th>중량</th>
					<td>600g</td>
				</tr>
			</table>
		</ul>
	</div>
	<div id= "comment">
		<div>댓글</div>
		<input id= "input" placeholder="댓글을 입력해 주세요.">
		<button id= "submit">등록</button>
	</div>
	<div class="commentlist">
		<ol>
			<div>
				<div class="info">
					<span class="name">USER1</span><br>
					<span class="date">2022.11.30 17:27</span>
				</div>
			</div>
			<p>든든하네요</p>			
		</ol>
	</div>
					
</body>
</html>