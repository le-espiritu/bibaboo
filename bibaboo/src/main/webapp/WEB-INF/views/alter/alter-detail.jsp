<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">

	<div class="card">
	
		<section class="infor">
			<div class="alter-img">
				<img src="/bibaboo/img/upload/${alterationsAndReviewsDTO.alterationsDTO.photoName}" alt="alternations_image" >
				<div>
					<p>${alterationsAndReviewsDTO.alterationsDTO.name}</p>
				</div>
			</div>
				
			<div class="alter-detail">
				<div>
					<p>수선집 정보</p>
					<div>
						<p>상호 : ${alterationsAndReviewsDTO.alterationsDTO.name }</p>
						<p>주소 : ${alterationsAndReviewsDTO.alterationsDTO.address}</p>
						<p>전화번호 : ${alterationsAndReviewsDTO.alterationsDTO.telNumber}</p>
						<p>영업 시간 : ${alterationsAndReviewsDTO.alterationsDTO.openTime} - ${alterationsAndReviewsDTO.alterationsDTO.closeTime}</p>
						<p>평균 별점: ${alterationsAndReviewsDTO.alterationsDTO.avgScore} 점</p>
					</div>
				</div>
			</div>
		</section>
		
		<section class="order">
			<button onclick="location.href='/bibaboo/alterations/${alterationsAndReviewsDTO.alterationsDTO.id}/category'" class="btn">
				<p>수선 신청 하기</p>
			</button>
		</section>
		
		<section class="write-box" >
			<h3>소중한 이용후기를 남겨주세요:)</h3>
			
			<form action="/bibaboo/review" method="post" enctype="multipart/form-data">
			<!-- 파일 업로드를 위해 반드시 enctype="multipart/form-data" 적어줘야함 -->
				<input type="hidden" name="userId" value="1"/> <!-- 이후 수정!!!!!!!!!!!!!!!!!!!!!!!!!1 -->
				<input type="hidden" name="alterId" value="${alterationsAndReviewsDTO.alterationsDTO.id}"/>
				
				<div>
					<select name="categoryId">
						<!-- 
						<option value="pants">바지</option>
						<option value="shirts">셔츠</option>
						 -->
						
						<option value="">수선 품목</option>
						<c:forEach items="${alterationsAndReviewsDTO.alterationsDTO.categoryList}" var="categoryDTO">
							<option value="${categoryDTO.id}">${categoryDTO.name}</option>
						</c:forEach>
					</select>
					
					<div class="star-rating">
						<input type="radio" id="5-stars" name="score" value="5" v-model="ratings"/>
						<label for="5-stars" class="star pr-4">★</label>
						<input type="radio" id="4-stars" name="score" value="4" v-model="ratings"/>
						<label for="4-stars" class="star">★</label>
						<input type="radio" id="3-stars" name="score" value="3" v-model="ratings"/>
						<label for="3-stars" class="star">★</label>
						<input type="radio" id="2-stars" name="score" value="2" v-model="ratings"/>
						<label for="2-stars" class="star">★</label>
						<input type="radio" id="1-star" name="score" value="1" v-model="ratings" />
						<label for="1-star" class="star">★</label>
					</div>
				</div>
				
				<textarea rows="5" style="width:100%;" name="content"></textarea>
				
				<div>
					<!-- <label>사진 등록 : </label> -->
					<input type="file" name="files" multiple>
				</div> 
				
				<div>
					<input type="submit" value="등록">
				</div>
			</form>
		</section>
		
		
		<section class="review-list">
			<div> 
				<h4>신데렐라들의 생생후기!</h4> 
			</div>
			
			<div class="star-ratings">
				<div class="star-ratings-fill">
					<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
				</div>
				<div class="star-ratings-base">
					<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
				</div>
			</div>
			
			<div class ="review">
				<table>
					<thead>
						<tr>
							<th>별점</th>
							<th>품목</th>
							<th>리뷰</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${alterationsAndReviewsDTO.reviewList}" var="reviewDTO">
							<tr>
								<td>${reviewDTO.score} 점</td>
								<td>${reviewDTO.categoryName}</td>
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
								<td>${reviewDTO.userId}</td>
								<td>${reviewDTO.createDate}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
		
	</div>
	
</section>

<script src="/bibaboo/js/alter/alter-detail.js"></script>