<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세 페이지</title>
<link rel="stylesheet" href="css/product/detail.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<%@include file="/WEB-INF/views/include/nav2.jsp"%>
<style>
body {
	height: 1500px;
	overflow-x: auto;
	overflow-y: auto;
	white-space: nowrap;
}

span {
	position: relative;
	top: 5px;
	left: 250px;
}

.name {
	position: relative;
	top: 0px;
	left: 0px;
}

.date {
	position: relative;
	top: 0px;
	left: 0px;
}

.icon {
	position: relative;
	top: -73px;
	left: 29px;
}

.info {
	overflow: hidden;
}

.info img {
	float: left;
	position: relative;
	left: 250px;
	top: 50px;
}

.info ul {
	overflow: hidden;
	float: left;
	display: block;
	position: relative;
	left: 300px;
}

.info p {
	line-height: 60px;
}

.info p a {
	text-decoration-line: none;
	color: white;
}

.info select {
	margin-left: 20px;
}

		button.cart{
				cursor: pointer; 
				width: 25%; 
			    margin: 25px 20px;
			    border: none;
			    background-color: #1673ea;
			    color: #fff; 
			    font-size: 14px; 
			    font-weight: bold;
			    line-height: 50px;
			    
		}
		
		button.purchase{
			cursor: pointer; 
			width: 12%; 
		    margin: 25px 20px;
		    border: none;
		    background-color: #1673ea;
		    color: #fff; 
		    font-size: 14px; 
		    font-weight: bold;
		    line-height: 50px;
		    position: absolute;
    		top: 37%;
    		left: 50%;
		    
		}

input {
	width: 600px;
	height: 3.3em;
	position: relative;
	top: 50px;
	left: 210px;
}

#comment {
	position: relative;
	left: 75px;
}

#submit {
	background-color: rgb(0, 128, 255);
	width: 80px;
	height: 50px;
	font-size: 15px;
	font-weight: bold;
	color: aliceblue;
	border: none;
	cursor: pointer;
	position: relative;
	top: 52px;
	left: 204px;
}

.text {
	position: relative;
	top: 0px;
	left: 0px;
}

.commentlist {
	position: relative;
	top: 60px;
	left: 260px;
}

img {
	width: 400px;
	height: 400px;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/nav.jsp"%>
	<div class="info">
		<div class="image_wrap" 
			 data-filename="${eventInfo.fileName}"
			 data-productnumber="${eventInfo.product_number}"
			 data-path="${eventInfo.uploadPath}" 
			 data-uuid="${eventInfo.uuid}">
			<img>
		</div>
		<form action="/CartAdd" method="Post">
			<input type="hidden" name="product_name" value="${eventInfo.product_name}">
			<input type="hidden" name="product_price" value="${eventInfo.product_price}">
			<input type="hidden" name="product_number" value="${eventInfo.product_number}">	
		
		<ul>
			<p>상품명 : ${eventInfo.product_name}</p>
			<p>가격 : ${eventInfo.product_price}</p>
			<p>
				수량선택 
				<select name="product_stock">
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
				</select>
			<p>
				<button class="cart">장바구니 담기</button>
							    <script type="text/javascript">
    		function cartOrder(){
    			var result = confirm("${eventInfo.product_price}  ${eventInfo.product_stock}원을 결제하시겠습니까?")
    				if(result){
    					alert("결제가 완료되었습니다.");
    					location.href = "<c:url value='/DeleteCart' />";
    				} else {
    					alert("결제가 취소되었습니다.");
    					location.href = "/product/event/detail/event_detail?product_number=" + "${eventInfo.product_number}";
    					
    				}
    			}
    			</script>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</p>

			</form>
			<textarea style="width: 675px; height: 200px;" readonly="readonly">${eventInfo.product_desc}</textarea>
		</ul>
	</div>
	<button class="purchase" onclick="cartOrder()" >결제하기</button>

</body>
<script>
	$(document).ready(
			function() {

				/* 이미지 삽입 */
				const bobj = $(".image_wrap");

				if (bobj.data("productnumber")) {
					const uploadPath = bobj.data("path");
					const uuid = bobj.data("uuid");
					const fileName = bobj.data("filename");
					const fileCallPath = encodeURIComponent(uploadPath + "/s_"
							+ uuid + "_" + fileName);

					bobj.find("img").attr('src',
							'/display?fileName=' + fileCallPath);
				} else {
					bobj.find("img")
							.attr('src', '/resources/image/nothing.png');
				}

			});
	//$(document).ready(function(){
	// 수량 버튼 조작
	let quantity = $(".quantity_input").val();
	$(".plus_btn").on("click", function() {
		$(".quantity_input").val(++quantity);
	});
	$(".minus_btn").on("click", function() {
		if (quantity > 1) {
			$(".quantity_input").val(--quantity);
		}
	});
</script>
</html>