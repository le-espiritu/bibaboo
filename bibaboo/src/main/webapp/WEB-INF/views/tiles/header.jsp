<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<header>
	<h1 OnClick="location.href ='/bibaboo/'">BI BA BOO!</h1>
	
	<nav>
		<ul>
			<li><a href="#">수선집 검색</a></li>
			<li>
				<sec:authorize access="isAuthenticated()">
					<a href="/bibaboo/cart/<sec:authentication property='principal.user.id'/>">장바구니</a>
				</sec:authorize>
			</li>
		</ul>

		<ul>
			<sec:authorize access="isAuthenticated()"> <!-- 로그인 상태를 확인 -->
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="/bibaboo/user/mypage">마이 페이지</a></li> 
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/bibaboo/admin">관리자 페이지</a></li>
				</sec:authorize>
				
			</sec:authorize>
			
			<sec:authorize access="isAnonymous()"> <!-- 비로그인 상태를 확인 -->
				<li><a href="/bibaboo/login-page">로그인</a></li>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<li><a href="/bibaboo/logout">로그아웃</a></li>
			</sec:authorize>
			
		</ul>
	</nav>
</header>