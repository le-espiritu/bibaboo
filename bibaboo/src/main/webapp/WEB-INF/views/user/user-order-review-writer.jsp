<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 
<div class="title-card">
	<p>수선 후기 작성</p>
</div>

<div class="card">
	
	<div class="write-box" >
		
		<h3>소중한 이용후기를 남겨주세요:)</h3>
		
		<div>
			<h4>수선집 상호 : ${orderCategoryDTO.alterName}</h4>
			<h4>수선 품목 : ${orderCategoryDTO.categoryName}</h4>
		</div>
		
		<form action="/bibaboo/review" method="post" enctype="multipart/form-data">
		<!-- 파일 업로드를 위해 반드시 enctype="multipart/form-data" 적어줘야함 -->
			<input type="hidden" name="userId" value="<sec:authentication property='principal.user.id'/>"/> <!-- 이후 수정!!!!!!!!!!!!!!!!!!!!!!!!!1 -->
			<input type="hidden" name="alterId" value="${orderCategoryDTO.alterId}"/>
			<input type="hidden" name="categoryId" value="${orderCategoryDTO.categoryId}"/>
			<input type="hidden" name="orderCategoryId" value="${orderCategoryDTO.orderCategoryId}"/>
			
			<div>
				
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
	</div>
	
</div>

	