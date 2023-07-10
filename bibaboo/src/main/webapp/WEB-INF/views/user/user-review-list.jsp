<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="title-card">
	<p>내가 작성한 리뷰 리스트</p>
</div>

<div class="card">
	
	<div class="search-section">
		
	</div>
	
	<div class="review">
		<table>
			<thead>
				<tr>
					<th>수선집</th>
					<th>품목</th>
					<th>별점</th>
					<th>리뷰</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reviewPageDTO.reviewList}" var="reviewDTO">
					<tr>
						<td>
							<a href="/bibaboo/alterations/${reviewDTO.alterId}">${reviewDTO.alterName }</a>
						</td>
						<td>${reviewDTO.categoryName}</td>
						<td>${reviewDTO.score} 점</td>
						<td>
							<c:if test="${not empty reviewDTO.reviewPhotos}">
								<div class="review-photo-div">
									<c:forEach items="${reviewDTO.reviewPhotos}" var="reviewPhotoDTO">
										<img alt="reviewPhotoImage" src="/bibaboo/img/upload/${reviewPhotoDTO.name}">
									</c:forEach>
								</div>		
							</c:if>
							
							<div>
								${reviewDTO.content}
								<!-- 추후 if문으로 처리 -->
								<div>
									<input type="hidden" class="user-id" value="1"/><!-- !!!!!!!추후 유저 id 수정!!!!!!!!!! -->
									<input type="hidden" class="review-id" value="${reviewDTO.id}"/>
									<input type="hidden" class="alter-id" value="${reviewDTO.alterId}"/>
									<input type="hidden" class="category-id" value="${reviewDTO.categoryId }"/>
									<input type="hidden" class="score-input" value="${reviewDTO.score }"/>
									<button class="update-view-btn">
										수정
									</button>
									<button class="delete-review-btn">
										삭제
									</button>
								</div>
								
							</div>
						</td>
						<td>${reviewDTO.createDate}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="page-info">
	
		<form class="moveForm" method="get" >
			<input type="hidden" name="pageNum" value="${reviewPageDTO.pageDTO.criteria.pageNum}">
			<input type="hidden" name="amount" value="${reviewPageDTO.pageDTO.criteria.amount}">
			<%-- <input type="hidden" name="keyword" value="${alterationsWithPagingDTO.pageDTO.criteria.keyword}"> --%>
			<%-- 자바스크립트에서 동적으로 input태그 생성하도록 해서 주석처리함  --%>
		</form>
	
		<ul>
			<!-- 이전 페이지 버튼 -->
			<c:if test="${reviewPageDTO.pageDTO.prev}">
				<li><a href="${reviewPageDTO.pageDTO.startPage-1}">Previous</a></li>
			</c:if>
			
			<!-- 각 번호 페이지 버튼 -->
			<c:forEach var="num" begin="${reviewPageDTO.pageDTO.startPage}" end="${reviewPageDTO.pageDTO.endPage}">
				<li class="${reviewPageDTO.pageDTO.criteria.pageNum == num? 'active':'' }"><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${reviewPageDTO.pageDTO.next}">
				<li><a href="${reviewPageDTO.pageDTO.endPage+1}">Next</a></li>
			</c:if>
		</ul>
		
	</div>
	
</div>

<script src="/bibaboo/js/user/user-order-list.js"></script>
	