<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">

	<div class="login-card">
		<form action="/bibaboo/login" method="post">
		  <h2>Login</h2>
		  
		  <c:if test="${param.error != null}">
		    <p>아이디와 비밀번호가 정보가 일치하지 않습니다.</p>
		  </c:if>
		  
		  <div class="idForm">
		    <input type="text" name="userEmail" placeholder=" email" value="" >
		  </div>
		  <div class="passForm">
		    <input type="password" name="password" placeholder=" password" >
		  </div>
		  
		  <button type="submit" class="btn">
		    LOG IN
		  </button>
		</form>
		
		<div class="bottom-text">
		  <p>아직 회원이 아니신가요? <a href="/bibaboo/user-join-page">가입하기</a></p>
		  <p>업체 등록 및 가입 <a href="/bibaboo/owner-join-page">가입하기</a></p>
		</div>
	</div>

</section>
