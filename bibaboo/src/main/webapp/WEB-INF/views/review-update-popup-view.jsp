<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리뷰 수정</title>
	
	<link rel="stylesheet" href="/bibaboo/css/popup/review/review-update-popup-view.css">
</head>
<body>

	<div class="write-box" >
		
		<h3>리뷰 수정 페이지 </h3>
		
		<div>
			<h4>수선 품목 : ${reviewInfo.categoryName}</h4>
			${reviewInfo.id}
		</div>
		
		<form class="review-update-form" action="/bibaboo/review" method="post">
		
			<input type="hidden" name="_method" value="patch">
			
			<input type="hidden" name="userId" value="${userId}"/> <!-- 이후 수정!!!!!!!!!!!!!!!!!!!!!!!!!1 -->
			<input type="hidden" name="id" value="${reviewInfo.id}"/>
			<input type="hidden" name="alterId" value="${reviewInfo.alterId}"/>
			<input type="hidden" name="categoryId" value="${reviewInfo.categoryId }"/>
			<input type="hidden" name="previousScore" value="${reviewInfo.score}"/>
			
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
			
			<textarea rows="5" style="width:100%;" name="content">${reviewInfo.content}</textarea>
			
			<!-- <div>
				<label>사진 등록 : </label>
				<input type="file" name="files" multiple>
			</div>  -->
			
			<div>
				<input type="submit" class="update-review-btn" value="수정">
			</div>
		</form>
	</div>

	<script src="/bibaboo/js/popup/review/review-update-popup-view.js"></script>
	
</body>
</html>