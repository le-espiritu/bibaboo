<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<aside>
	<div class="aside-card">
		<h1>마이 페이지</h1>
		<br>
		<br>
		<sec:authorize access="hasRole('ROLE_OWNER')">
			<p><a href="/bibaboo/owner/owner-page">수선집 관리 페이지</a></p>
			<br> 
		</sec:authorize>
		<p><a href="/bibaboo/user/mypage/info">내정보 관리</a></p>
		<br>
		<p><a href="/bibaboo/user/mypage/order-list?userId=<sec:authentication property="principal.user.id"/>">주문 내역</a></p>
		<br>
		<p><a href="/bibaboo/user/mypage/review?userId=<sec:authentication property="principal.user.id"/>">내 리뷰 관리</a></p>
		<br>
	</div>
</aside>