<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<input type="hidden" class="user-id-input" value='<sec:authentication property="principal.user.id"/>'>

<aside>
	<div class="aside-card">
		<h1>사장님 페이지</h1>
		<br>
		<br>
		<p>
			<a href="/bibaboo/owner/owner-page/alterations-register-page"  class="goto-register-page">
				수선집 등록 하기
			</a>
		</p>
		<br>
		<p><a href="/bibaboo/owner/owner-page/info?alterId=<sec:authentication property='principal.user.alterId'/>">수선집 정보 관리</a></p>
		<br>
		<p><a href="/bibaboo/owner/owner-page/category-register-page?alterId=<sec:authentication property='principal.user.alterId'/>">수선 품목 관리</a></p>
		<br>
		<p><a href="/bibaboo/user/mypage/order-list?userId=<sec:authentication property="principal.user.id"/>">주문 내역</a></p>
		<br>
	</div>
</aside>

<script src="/bibaboo/js/tiles/owner-page-aside.js"></script>

