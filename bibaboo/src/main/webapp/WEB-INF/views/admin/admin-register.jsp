<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="title-card">
	<p>수선집 등록 페이지</p>
</div>

<div class="register-card">
	
	<form action="/webproject/menu/join.do" method="POST" >
		<h3>등록할 수선집 정보를 입력해주세요.</h3> 
		
		<div> 
			<label>상호명</label> 
			<input type="text" name="alterName" placeholder="수선집 상호명" required> 
		</div> 
			
		<div> 
			<label>주소</label> 
			<input type="text" name="address" placeholder="서울특별시 강남구" required> 
		</div> 
			
		<div>
			<label>전화 번호</label>
			<input type="text" name="telNumber" placeholder="전화 번호를 입력해주세요." required>
		</div> 
		
		<div>
			<label>오픈 타임</label>
			<input type="time" name="openTime" required>
		</div> 
		
		<div>
			<label>클로즈 타임</label>
			<input type="time" name="closeTime" required>
		</div> 
		
		<div>
			<label>대표 사진</label>
			<input type="file" name="photo" required>
		</div> 
		
		<button class="btn" type="submit">등록 하기</button>
	</form>
	
</div>