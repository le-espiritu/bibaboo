<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="title-card">
	<p>수선집 정보 수정 페이지</p>
</div>

<div class="body-card">
	
	<form action="/bibaboo/alterations/${alterInfo.id}" method="POST" >
	<!-- 파일 업로드를 위해 반드시 enctype="multipart/form-data" 적어줘야함 -->
	
		<input type="hidden" name="_method" value="patch">
	
		<h3>수선집 정보를 수정해주세요.</h3> 
		
		<div> 
			<label>상호명</label> 
			<input type="text" name="name" value="${alterInfo.name }" required> 
		</div> 
			
		<div> 
			<label>주소</label> 
			<input type="text" name="address" value="${alterInfo.address }" required> 
		</div> 
			
		<div>
			<label>전화 번호</label>
			<input type="text" name="telNumber" value="${alterInfo.telNumber }" required>
		</div> 
		
		<div>
			<label>오픈 타임</label>
			<input type="time" name="openTime" required>
		</div> 
		
		<div>
			<label>클로즈 타임</label>
			<input type="time" name="closeTime" required>
		</div> 
		
		<!-- <div>
			<label>대표 사진</label>
			<input type="file" name="file" >
		</div>  -->
		<!-- multipart/form-data 경우 patch,put,delete 지원하지 않기 때문에 주석처리함  -->
		<!-- https://mangkyu.tistory.com/218 포스팅 참고 -->
		
		<button class="btn" type="submit">수정 하기</button>
	</form>
	
</div>