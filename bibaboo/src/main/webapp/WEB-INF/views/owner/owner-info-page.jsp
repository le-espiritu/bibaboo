<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="card">
	<h1>내 수선집 상세 정보 </h1>
	
	<div class="user-info-section">
		
		<div>
			<label>대표 사진</label>
			<img alt="alter-photo" src="/bibaboo/img/upload/${alterationsDTO.photoName}">
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
			<label>주소</label>
			<p>${alterationsDTO.address}</p>
		</div>
		<div>
			<label>전화번호</label>
			<p>${alterationsDTO.telNumber}</p>
		</div>
		<div>
			<label>영업시간</label>
			<p>${alterationsDTO.openTime} - ${alterationsDTO.closeTime}</p>
		</div>
		<div>
			<label>리뷰 평점</label>
			<p>${alterationsDTO.avgScore}</p>
		</div>
		
	</div>
	
</div>

