<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="title-card">
	<p>회원 관리</p>
</div>

<div class="card">
	
	<div class="search-section">
		<div>
			<select name="type">
				<option value="" <c:out value="${userListAndPageDTO.pageDTO.criteria.type == null? 'selected' : '' }"></c:out> >검색 조건</option>
				<option value="id" <c:out value="${userListAndPageDTO.pageDTO.criteria.type eq 'O'? 'selected' : '' }"></c:out> >사용자 번호</option>
				<option value="email" <c:out value="${userListAndPageDTO.pageDTO.criteria.type eq 'N'? 'selected' : '' }"></c:out> >사용자 이메일</option>
				<option value="name" <c:out value="${userListAndPageDTO.pageDTO.criteria.type eq 'A'? 'selected' : '' }"></c:out> >사용자 이름</option>
				<option value="email name" <c:out value="${userListAndPageDTO.pageDTO.criteria.type eq 'ON'? 'selected' : '' }"></c:out> >이메일 + 이름</option>
			</select>
			<input type="text" name="keyword" class="keyword" value="${userListAndPageDTO.pageDTO.criteria.keyword}"/>
			<button>Search</button>
		</div>
	</div>
	
	<div class="alter-list">
		<table>
			<thead>
				<tr>
					<th>no</th>
					<th>사용자 아이디</th>
					<th>성명</th>
					<th>전화번호</th>
					<th>가입일자</th>
					<th>탈퇴 여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userListAndPageDTO.userList}" var="userInfo">
					<tr>
						<td>${userInfo.id}</td>
						<td>${userInfo.email}</td>
						<td>${userInfo.name}</td>
						<td>${userInfo.phoneNumber}</td>
						<td>${userInfo.createDate}</td>
						<td>
							<c:if test="${userInfo.enable == 1}">
								활동 중
							</c:if>
							<c:if test="${userInfo.enable == 0}">
								탈퇴
							</c:if>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="page-info">
	
		<form class="moveForm" method="get" >
			<input type="hidden" name="pageNum" value="${userListAndPageDTO.pageDTO.criteria.pageNum}">
			<input type="hidden" name="amount" value="${userListAndPageDTO.pageDTO.criteria.amount}">
			<%-- <input type="hidden" name="keyword" value="${alterationsWithPagingDTO.pageDTO.criteria.keyword}"> --%>
			<%-- 자바스크립트에서 동적으로 input태그 생성하도록 해서 주석처리함  --%>
		</form>
	
		<ul>
			<!-- 이전 페이지 버튼 -->
			<c:if test="${userListAndPageDTO.pageDTO.prev}">
				<li><a href="${userListAndPageDTO.pageDTO.startPage-1}">Previous</a></li>
			</c:if>
			
			<!-- 각 번호 페이지 버튼 -->
			<c:forEach var="num" begin="${userListAndPageDTO.pageDTO.startPage}" end="${userListAndPageDTO.pageDTO.endPage}">
				<li class="${userListAndPageDTO.pageDTO.criteria.pageNum == num? 'active':'' }"><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${userListAndPageDTO.pageDTO.next}">
				<li><a href="${userListAndPageDTO.pageDTO.endPage+1}">Next</a></li>
			</c:if>
		</ul>
		
	</div>
	
</div>

<script src="/bibaboo/js/admin/admin-user-list.js"></script>
	