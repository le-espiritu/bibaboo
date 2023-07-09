<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="title-card">
	<p>주문 상세</p>
</div>

<div class="card">
	
	<div>
		
		<p>주문번호 : ${orderCategoryList[0].orderId} </p>
	</div>
	<div class="alter-list">
		<table>
			<thead>
				<tr>
					<th>수선집 상호</th>
					<th>수선 품목</th>
					<th>개수</th>
					<th>결제 금액</th>
					<th>주문 상태</th>
					<th>주문 취소</th>
					<th>후기 작성</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderCategoryList}" var="orderCategory">
					<tr>
						<td>${orderCategory.alterName}</td>
						<td>${orderCategory.categoryName}</td>
						<td>${orderCategory.count}</td>
						<td>${orderCategory.totalPrice}</td>
						<td>${orderCategory.state}</td>
						<td>
							<form action="/bibaboo/order" method="post">
								<input type="hidden" name="_method" value ="delete"/>
								<input type="hidden" name="userId" value="${orderDTO.userId}"/>
								<input type="hidden" name="orderId" value="${orderDTO.id}" />
								<input type="hidden" name="keyword" value="${orderListAndPageDTO.pageDTO.criteria.keyword}"/>
								<input type="hidden" name="amount" value="${orderListAndPageDTO.pageDTO.criteria.amount}"/>
								<input type="hidden" name="pageNum" value="${orderListAndPageDTO.pageDTO.criteria.pageNum}"/>
								<button onclick="return confirm('정말로 주문 취소 하시겠습니까?')">주문 취소</button>
							</form>
						</td>
						<td>
							<form class="write-review-form" action="/bibaboo/user/mypage/review-writer-page" method="post">
								<input type="hidden" class="user-id" name="userId" value="<sec:authentication property='principal.user.id'/>"/>
								<input type="hidden" class="order-category-id" name="orderCategoryId" value="${orderCategory.orderCategoryId}"/>
								<input type="hidden" name="alterId" value="${orderCategory.alterId}"/>
								<input type="hidden" name="categoryId" value="${orderCategory.categoryId}"/>
								<input type="hidden" name="alterName" value="${orderCategory.alterName}"/>
								<input type="hidden" name="categoryName" value="${orderCategory.categoryName}"/>
								<button class="write-review-btn"> 리뷰 작성 </button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</div>

<script src="/bibaboo/js/user/user-order-detail.js"></script>

	