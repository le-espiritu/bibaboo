<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="title-card">
	<p>주문 리스트</p>
</div>

<div class="card">
	
	<div class="search-section">
		<div>
			<select name="type">
				<option value="" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type == null? 'selected' : '' }"></c:out> >검색 조건</option>
				<option value="O" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type eq 'O'? 'selected' : '' }"></c:out> >사장님 식별 번호</option>
				<option value="N" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type eq 'N'? 'selected' : '' }"></c:out> >상호명</option>
				<option value="A" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type eq 'A'? 'selected' : '' }"></c:out> >주소</option>
				<option value="ON" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type eq 'ON'? 'selected' : '' }"></c:out> >사장님 + 상호명</option>
				<option value="NA" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type eq 'ON'? 'selected' : '' }"></c:out> >상호명 + 주소</option>
				<option value="ONA" <c:out value="${alterationsWithPagingDTO.pageDTO.criteria.type eq 'ONA'? 'selected' : '' }"></c:out> >사장님 + 상호명 + 주소</option>
			</select>
			<input type="text" name="keyword" value="${alterationsWithPagingDTO.pageDTO.criteria.keyword}"/>
			<button>Search</button>
		</div>
	</div>
	
	<div class="order-list">
		<table>
			<thead>
				<tr>
					<th>주문 번호</th>
					<th>수선 품목</th>
					<th>결제 금액</th>
					<th>주문 날짜</th>
					<th>주문자 정보</th>
					<th>주문 상태</th>
					<th>상태 변경</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderCategoryAndPageDTO.orderCategoryList}" var="order">
					<tr>
						<td>${order.orderCategoryId}</td>
						<td>${order.categoryName}</td>
						<td>${order.totalPrice}</td>
						<td>${order.createDate}</td>
						<td>
							<form class="user-info-form">
								<input type="hidden" name="email" value="${order.userEmail}"/>
								<input type="hidden" name="name" value="${order.userName }"/>
								<input type="hidden" name="phoneNumber" value="${order.userPhoneNumber}"/>
								<button class="user-info-btn">주문자 정보 보기</button>
							</form>
						</td>
						<td><button onclick="location.href='/bibaboo/user/mypage/order-list/${orderDTO.id}'">상세 보기</button></td>
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="page-info">
	
		<form id="moveForm" method="get" >
			<input type="hidden" name="pageNum" value="${orderListAndPageDTO.pageDTO.criteria.pageNum}">
			<input type="hidden" name="amount" value="${orderListAndPageDTO.pageDTO.criteria.amount}">
			<%-- <input type="hidden" name="keyword" value="${alterationsWithPagingDTO.pageDTO.criteria.keyword}"> --%>
			<%-- 자바스크립트에서 동적으로 input태그 생성하도록 해서 주석처리함  --%>
		</form>
	
		<ul>
			<!-- 이전 페이지 버튼 -->
			<c:if test="${orderListAndPageDTO.pageDTO.prev}">
				<li><a href="${orderListAndPageDTO.pageDTO.startPage-1}">Previous</a></li>
			</c:if>
			
			<!-- 각 번호 페이지 버튼 -->
			<c:forEach var="num" begin="${orderListAndPageDTO.pageDTO.startPage}" end="${orderListAndPageDTO.pageDTO.endPage}">
				<li class="${orderListAndPageDTO.pageDTO.criteria.pageNum == num? 'active':'' }"><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${orderListAndPageDTO.pageDTO.next}">
				<li><a href="${orderListAndPageDTO.pageDTO.endPage+1}">Next</a></li>
			</c:if>
		</ul>
		
	</div>
	
</div>

<script src="/bibaboo/js/owner/owner-order-list.js"></script>
	