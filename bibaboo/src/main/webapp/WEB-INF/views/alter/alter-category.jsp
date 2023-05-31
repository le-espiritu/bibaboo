<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">

	<div class="card title">
		<p>${categories.categoryList[0].alterName} 수선 신청</p>
	</div>

	<div class="card">
		
		<c:forEach items="${categories.categoryList}" var="category">
			<section>
				<button class="category-card" onclick="javascript:addCart(1,${category.id},1)">
					<div>
						<p>${category.name} 수선</p>
						<p>${category.price}원</p>
					</div>
				</button>
			</section>
		</c:forEach>
		
	</div>

</section>

<script src="/bibaboo/js/alter/alter-category.js"></script>
