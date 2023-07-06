<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">

	<div class="card title">
		<p>수선 신청 주문 페이지</p>
	</div>
	
	
	<div class="card">
	
		<section class="user-info-section">
			<h2>주문자 정보</h2>
			<div>
				<table>
					<thead>
						<tr>
							<th></th>
							<th>아이디</th>
							<th>성명</th>
							<th>연락처</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td class="user-info-td">
								<input type="hidden" class="user-id-input" value="${userInfo.id}">
								<input type="hidden" class="user-email-input" value="${userInfo.email}">
								<input type="hidden" class="user-name-input" value="${userInfo.name}">
								<input type="hidden" class="user-phoneNumber-input" value="${userInfo.phoneNumber}">
							</td>
							<td>${userInfo.email}</td>
							<td>${userInfo.name}</td>
							<td>${userInfo.phoneNumber}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
		
		<hr>
		
		<h2>주문 상세 정보</h2>
		<table>
			<thead>
				<tr>
					<th></th> <!-- tbody의 hidden값을 위한 fake  -->
					<th>수선집 상호</th>
					<th>수선 품목명</th>
					<th>수량</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderList}" var="order">
					<tr>
						<td class="order-info-td">
							<input type="hidden" class="count-input" value="${order.count}">
							<input type="hidden" class="price-input" value="${order.totalPrice}">
							<input type="hidden" class="category-id-input" value="${order.categoryId}">
							<input type="hidden" class="alter-id-input" value="${order.alterId}">
						</td>
						<td>${order.alterName}</td>
						<td>${order.categoryName}</td>
						<td>${order.count}</td>
						<td>${order.totalPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<section class="total-info-section">
			<div>
				<span>총 주문 수량 : </span>
				<span class="sum-count-span"></span>
				<span> EA </span>
				<span> / </span>
				<span>총 결제 가격 : </span>
				<span class="sum-price-span"></span>
				<input type="hidden" class="sum-price-input">
				<span> 원 </span>
			</div>
		</section>
		
		<section class="pay-btn-section">
			<button class="pay-btn">
				<span class="btn-sum-price-span"></span> 원 
				결제 하기
			</button>
		</section>
		
	</div>

</section>

<script src="/bibaboo/js/order/order-page.js"></script>
