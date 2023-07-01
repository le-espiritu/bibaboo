<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="card">
	<h1>${userInfo.name} 님 회원 정보 </h1>
	
	<div class="user-info-section">
		
		<div>
			<label>회원 번호</label>
			<p>${userInfo.id}</p>
		</div>
		<div>
			<label>성명</label>
			<p>${userInfo.name}</p>
		</div>
		<div>
			<label>이메일</label>
			<p>${userInfo.email}</p>
		</div>
		<div>
			<label>가입일</label>
			<p>${userInfo.createDate}</p>
		</div>
		
	</div>
	
</div>

