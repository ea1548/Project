<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/index/adressstyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>

</head>
<%@include file="/WEB-INF/views/include/nav.jsp" %>
<body>


	<form style="text-align:center" class="address" action="/AddressInsert" method="POST">
		<h4>배송지 관리 목록</h4>
	
	
		<div class="address_wrap">
			<div class="address_name">
			<div class="address_button" onclick="sample6_execDaumPostcode()"> 
				</div>
				</div>
			<div class="address_input_1_wrap">
				<div class="address_input_1_box">
					<input class="address_input_1" name="member_address1" readonly="readonly" value="${deliver_address.member_address1}">
				</div>
				
				<div class="address_input_2_wrap">
					<div class="address_input_2_box">
						<input class="address_input_2" name="member_address2" readonly="readonly" value="${deliver_address.member_address2}">
					</div>
				</div>
					
				<div class="address_input_3_wrap" id="member_address3">
					<div class="address_input_3_box">
						<input class="address_input_3" name="member_address3" readonly="readonly" value="${deliver_address.member_address3}">
						</br><button type="submit">등록하기</button>
						
					</div>
				</div>
				----------------------------------------- <!-- 이 영역 삭제 -->

			</div>
			
			<div class="move" style="text-align:center">
			<span>배송지 목록</span>
			
			<div id="addressList">
				<c:forEach var="addressOne" items="${addressOne}" varStatus="varStatus">
					<input type="text" id="address${varStatus.index}" name="addressList" value="${addressOne.member_address1} ${addressOne.member_address2} ${addressOne.member_address3}" readonly>
					<div class="address_button"> 
						<div id ="updateAddress">
							<a href="/AddressUpdate?address_member_no=${addressOne.member_address_no}">배송지 수정</a> <!-- ?address_member_no=${address.member_address_no}" -->
						</div>		
					</div>
					<div id="deleteAddress">
						<a href="/AddressDelete?address_member_no=${addressOne.member_address_no}">배송지 삭제</a>
					</div>
				</c:forEach>
			</div>
			
			
			<div class="address_wrap">
			<div class="address_name">
			
					<div class="clearfix"></div>
				</div>
			</div>
		</div>	
	</div>	
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js">
		/* 다음 주소 연동 */
		function execution_daum_address(){
    		new daum.Postcode({
        		oncomplete: function(data) {
            		<!-- 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다. --> 
            		
            		<input type="text" id="sample6_postcode" placeholder="우편번호">
            		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
            		<input type="text" id="sample6_address" placeholder="주소"><br>
            		<input type="text" id="sample6_detailAddress" placeholder="상세주소">
            		<input type="text" id="sample6_extraAddress" placeholder="참고항목">

            		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            		<script>
            		    function sample6_execDaumPostcode() {
            		        new daum.Postcode({
            		            oncomplete: function(data) {
            		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            		                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            		                var addr = ''; // 주소 변수
            		                var extraAddr = ''; // 참고항목 변수

            		                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            		                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            		                    addr = data.roadAddress;
            		                } else { // 사용자가 지번 주소를 선택했을 경우(J)
            		                    addr = data.jibunAddress;
            		                }

            		                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            		                if(data.userSelectedType === 'R'){
            		                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            		                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            		                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
            		                        extraAddr += data.bname;
            		                    }
            		                    // 건물명이 있고, 공동주택일 경우 추가한다.
            		                    if(data.buildingName !== '' && data.apartment === 'Y'){
            		                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            		                    }
            		                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            		                    if(extraAddr !== ''){
            		                        extraAddr = ' (' + extraAddr + ')';
            		                    }
            		                    // 주소변수 문자열과 참고항목 문자열 합치기
            		                    addr += extraAddr;
            		                
            		                } else {
            		                	addr += ' ';
            		                }
            		               // $(".address_input_1").val(data.zonecode);
            		                $("[name=member_address1]").val(data.zonecode);
            		                //$(".address_input_2").val(addr);
            		                $("[name=member_address2]").val(addr); 
            		                // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
            		                $(".address_input_3").attr("readonly",false);
            		                 $(".address_input_3").focus();
            		            }
            		        }).open();
            		    }
            		</script>
            <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />		
       </form>
       <div style = "text-align: center" class="address_button" onclick="sample6_execDaumPostcode()"> 
				<button >배송지 추가</button>
				</div>     		
</body>
</html>