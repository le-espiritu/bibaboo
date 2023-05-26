<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="title-card">
	<p>등록된 수선집 리스트</p>
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
	
	<div class="alter-list">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>사장님 아이디</th>
					<th>상호</th>
					<th>주소</th>
					<th>전화번호</th>
					<th>메뉴 등록</th>
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
						<td><button onclick="location.href='/bibaboo/admin/alterations/${alterations.id}/category-register-view'">메뉴 등록</button></td>
						<td><button onclick="location.href='/bibaboo/admin/alterations/${alterations.id}/update-view'">수정</button></td>
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
			<%-- <input type="hidden" name="keyword" value="${alterationsWithPagingDTO.pageDTO.criteria.keyword}"> --%>
			<%-- 자바스크립트에서 동적으로 input태그 생성하도록 해서 주석처리함  --%>
		</form>
	
		<ul>
			<!-- 이전 페이지 버튼 -->
			<c:if test="${alterationsWithPagingDTO.pageDTO.prev}">
				<li><a href="${alterationsWithPagingDTO.pageDTO.startPage-1}">Previous</a></li>
			</c:if>
			
			<!-- 각 번호 페이지 버튼 -->
			<c:forEach var="num" begin="${alterationsWithPagingDTO.pageDTO.startPage}" end="${alterationsWithPagingDTO.pageDTO.endPage}">
				<li class="${alterationsWithPagingDTO.pageDTO.criteria.pageNum == num? 'active':'' }"><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${alterationsWithPagingDTO.pageDTO.next}">
				<li><a href="${alterationsWithPagingDTO.pageDTO.endPage+1}">Next</a></li>
			</c:if>
		</ul>
		
	</div>
	
</div>

<script src="/bibaboo/js/admin/admin-alter-list.js"></script>
	