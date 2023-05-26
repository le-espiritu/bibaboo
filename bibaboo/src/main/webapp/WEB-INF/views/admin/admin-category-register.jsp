<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="title-card">
	<p>수선 품목 및 가격 등록 페이지</p>
</div>

<div class="register-card">
	
	<form action="/bibaboo/alterations/${alterationsDTO.id}/category" method="POST">
		<h3>수선 품목과 가격을 입력해주세요.</h3> 
		
		
		
		<c:forEach var="index" begin="0" end="7">
			<div> 
				<label>수선 품목</label> 
				<input type="hidden" name="categoryList[${index}].alterId" value="${alterationsDTO.id}">
				<select name="categoryList[${index}].name">
					<option value="">품목을 선택해주세요</option>
					<option value="pants">바지</option>
					<option value="shirts">셔츠</option>
					<option value="suit">정장</option>
					<option value="outer">아우터</option>
					<option value="jeans">청바지</option>
					<option value="skirt">치마</option>
					<option value="dress">원피스</option>
					<option value="reform">리폼</option>
				</select>
				<input type="number" name="categoryList[${index}].price" placeholder="가격을 입력해주세요"> 
			</div> 
		</c:forEach>
		
		<button class="btn" type="submit">등록 하기</button>
	</form>
	
</div>