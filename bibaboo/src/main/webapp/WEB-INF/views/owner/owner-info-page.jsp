<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="card">
	<h1>내 수선집 상세 정보 </h1>
	
	<div class="user-info-section">
		
		<div>
			<img alt="alter-photo" src="/bibaboo/img/upload/${alterationsDTO.photoName}">
			<label>등록된 수선집 사진</label>
		</div>
		<div>
			<label>수선집 no</label>
			<p>${alterationsDTO.id}</p>
		</div>
		<div>
			<label>수선집 상호</label>
			<p>${alterationsDTO.name}</p>
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

