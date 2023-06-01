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
					<th>수선 품목명</th>
					<th>가격</th>
					<th>수량</th>
					<th>삭제</th>
					<th>체크</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartInfo}" var="cartDto">
					<tr>
						<td>${cartDto.categoryName}</td>
						<td>${cartDto.totalPrice}</td>
						<td>${cartDto.count}</td>
						<td>
							<form action="/bibaboo/cart/${cartDto.userId}/${cartDto.id}" method="post">
								<input type="hidden" name="_method" value ="delete"/>
								<button onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</button>
							</form>
						</td>
						<td>체크박스</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>

</section>
