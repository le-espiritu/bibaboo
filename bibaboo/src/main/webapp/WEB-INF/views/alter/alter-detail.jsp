<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<input type="hidden" class="principal-username" value='<sec:authentication property="principal.username"/>'/>

<section class="content">

	<div class="card">
	
		<section class="infor">
			<div class="alter-img">
				<img src="/bibaboo/img/upload/${alterationsDTO.photoName}" alt="alternations_image" >
				<div>
					<p>${alterationsDTO.name}</p>
				</div>
			</div>
				
			<div class="alter-detail">
				<div>
					<p>수선집 정보</p>
					<div>
						<input type="hidden" class="alter-id-input" value="${alterationsDTO.id}"/>
						<p>상호 : ${alterationsDTO.name }</p>
						<p>주소 : ${alterationsDTO.address}</p>
						<p>전화번호 : ${alterationsDTO.telNumber}</p>
						<p>영업 시간 : ${alterationsDTO.openTime} - ${alterationsDTO.closeTime}</p>
						<p>평균 별점: ${alterationsDTO.avgScore} 점</p>
					</div>
				</div>
			</div>
		</section>
		
		<section class="order">
			<button onclick="location.href='/bibaboo/alterations/${alterationsDTO.id}/category'" class="btn">
				<p>수선 신청 하기</p>
			</button>
		</section>
		
		<section class="write-box" >
			<h3>소중한 이용후기를 남겨주세요:)</h3>
			
			<form action="/bibaboo/review" method="post" enctype="multipart/form-data">
			<!-- 파일 업로드를 위해 반드시 enctype="multipart/form-data" 적어줘야함 -->
				
				<input type="hidden" name="userId" value="<sec:authentication property="principal.userId"/>"/> 
				<input type="hidden" name="alterId" value="${alterationsDTO.id}"/>
				
				<div>
					<select name="categoryId">
						<!-- 
						<option value="pants">바지</option>
						<option value="shirts">셔츠</option>
						 -->
						
						<option value="">수선 품목</option>
						<c:forEach items="${alterationsDTO.categoryList}" var="categoryDTO">
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
		
		<section class="review-not-section">
			
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
					<tbody class="review-tbody">
					
						<!-- Templating 활용-->
							
					</tbody>
				</table>
			</div>
			
		</section>
		
		<section class="review-page-section">
			
		</section>
		
	</div>
	
</section>

<!-- Templating -->
<script id = "template-review-tbody-tr" type="text/template">
	<tr class="review-tr">
		<td>{score} 점</td>
		<td>{categoryName}</td>
		<td>
			<div class="review-photo-div">

			</div>		
								
			<div>
				{content}
				<!-- 추후 if문으로 처리 -->
				<div>

					<input type="hidden" class="user-id" value="{hiddenUserId}"/><!-- !!!!!!!추후 유저 id 수정!!!!!!!!!! -->
					<input type="hidden" class="user-email" value="{hiddenUserEmail}"/>
					<input type="hidden" class="review-id" value="{reviewId}"/>
					<input type="hidden" class="alter-id" value="{alterId}"/>
					<input type="hidden" class="category-id" value="{categoryId}"/>
					<input type="hidden" class="score-input" value="{hiddenScore}"/>

					<div class="btns-div">

					</div>
					
				</div>
			</div>
		</td>
		<td>{userEmail}</td>
		<td>{createDate}</td>
	</tr>
</script>

<script src="/bibaboo/js/alter/alter-detail.js"></script>