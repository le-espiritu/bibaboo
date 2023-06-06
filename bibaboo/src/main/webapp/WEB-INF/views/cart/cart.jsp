<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">

	<div class="card title">
		<p>장바구니 페이지</p>
	</div>

	<div class="card">
		
		<table>
			<thead>
				<tr>
					<th></th> <!-- tbody의 hidden값을 위한 fake  -->
					<th>수선 품목명</th>
					<th>가격</th>
					<th>수량</th>
					<th>삭제</th>
					<th>체크</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartInfo}" var="cartDto">
					<tr class="cart-info-tr">
						<td class="cart-info-td">
							<input type="hidden" class="cart-id" value="${cartDto.id}">
							<input type="hidden" class="cart-user-id" value="${cartDto.userId}">
							<input type="hidden" class="cart-category-id" value="${cartDto.categoryId}">
							<input type="hidden" class="cart-count-by-category" value="${cartDto.count}">
						</td>
						<td>${cartDto.categoryName}</td>
						<td class="total-price-td" >${cartDto.totalPrice}</td>
						<td class="count-td" >
							<button class="minus-btn">-</button>
							<input type="text" class="count-input" size="2" value="${cartDto.count}">
							<button class="plus-btn" >+</button>
							<button class="modify-btn">수정</button>
						</td>
						<td>
							<button class="delete-btn">삭제</button>
						</td>
						<td>체크박스</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<section class="total-info-section">
			<div>
				<span>총 수량 : </span>
				<span class="sum-count-span"></span>
				<span> EA </span>
				<span> / </span>
				<span>총 가격 : </span>
				<span class="sum-price-span"></span>
				<span> 원 </span>
			</div>
		</section>
		
		<section class="order-btn-section">
			<button class="order-btn">수선 신청 하기</button>
		</section>
		
	</div>

</section>

<script src="/bibaboo/js/cart/cart.js"></script>