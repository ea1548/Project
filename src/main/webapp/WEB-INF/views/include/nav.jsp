<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="/css/nav.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<meta charset="UTF-8">

<body>
	<div class="navbar">
      <ul>
      <sec:authorize access="isAuthenticated()">
      <sec:authentication property="principal.username" var="user_id" />
        <div id="user_id">${ user_id }님 안녕하세요. </div>	
      	<li><a href="/MemberInfo?member_id=${user_id}">마이페이지</a></li>
        <li><a href="/cart">장바구니</a></li>
        <li>
        	<form id="frm2" action="/logout" method="post">
        		<a href="#" onclick="return chk_form()" >로그아웃</a>
        		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
        	</form>
        </li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="/admin/admin_main">관리자페이지(관리자전용)</a></li>
        </sec:authorize>
	  </sec:authorize>
	  <sec:authorize access="isAnonymous()">
        <li><a href="/loginForm">로그인</a></li>
        <li><a href="/loginForm2">회원가입</a></li>
      </sec:authorize>
        </ul>
    </div>
    
    <div>
    	<a class="logo" href="/">Meal Kit</a>
    </div>

	<div id="SideMenu" class="sidemenu">
	  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
	  	<a href="/product/product_korea_list"" style= "white-space:nowrap;">한식</a>
		<a href="/product/product_china_list"" style="white-space:nowrap;">중식</a>
		<a href="/product/product_jap_list" style="white-space:nowrap;">일식</a>
		<a href="/product/product_eu_list" style="white-space:nowrap;">양식</a>
		<a href="/product/product_event_list" style="white-space:nowrap;">이벤트</a>
		<a href="/member/infoboard" style="white-space:nowrap;">정보공유 게시판</a>
		<a href="/member/freeboard" style="white-space:nowrap;">자유게시판</a>
		<a href="/member/customerboard" style="white-space:nowrap;">고객센터</a>
	</div>
	<span class="icon" style="font-size:30px; cursor:pointer" onclick="openNav()" >
		<i class="fa-solid fa-bars"></i>
	</span>
	 	
<script>
		function openNav() {
		    document.getElementById("SideMenu").style.width = "250px";
		}
		
		function closeNav() {
		    document.getElementById("SideMenu").style.width = "0";
		}

		function chk_form() {
		document.getElementById('frm2').submit();
		}

	
</script>