<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="title-card">
	<p>등록된 수선집 리스트</p>
</div>

<div class="card">
	
	<div class="alter-list">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>사장님 아이디</th>
					<th>상호</th>
					<th>주소</th>
					<th>전화번호</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alterationsWithPagingDTO.alterList}" var="alterations">
					<tr>
						<td>${alterations.id}</td>
						<td>${alterations.userId}</td>
						<td>${alterations.name}</td>
						<td>${alterations.address}</td>
						<td>${alterations.telNumber}</td>
						<td><button onclick="location.href='#'">수정</button></td>
						<td>
							<form action="/bibaboo//admin/alterations/${alterations.id}" method="post">
								<input type="hidden" name="_method" value ="delete"/>
								<button onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="page-info">
	
		<form id="moveForm" method="get" >
			<input type="hidden" name="pageNum" value="${alterationsWithPagingDTO.pageDTO.criteria.pageNum}">
			<input type="hidden" name="amount" value="${alterationsWithPagingDTO.pageDTO.criteria.amount}">
		</form>
	
		<ul>
			<!-- 이전 페이지 버튼 -->
			<c:if test="${alterationsWithPagingDTO.pageDTO.prev}">
				<li><a href="${alterationsWithPagingDTO.pageDTO.startPage-1}">Previous</a></li>
			</c:if>
			
			<!-- 각 번호 페이지 버튼 -->
			<c:forEach var="num" begin="${alterationsWithPagingDTO.pageDTO.startPage}" end="${alterationsWithPagingDTO.pageDTO.endPage}">
				<li><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${alterationsWithPagingDTO.pageDTO.next}">
				<li><a href="${alterationsWithPagingDTO.pageDTO.endPage+1}">Next</a></li>
			</c:if>
		</ul>
		
	</div>
	
</div>

<script src="/bibaboo/js/admin/admin-alter-list.js"></script>
	