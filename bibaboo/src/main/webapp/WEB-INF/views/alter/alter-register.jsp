<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="register-card">

		<form action="/webproject/menu/join.do" method="POST" >
			<h2>수선집 등록</h2> 
			
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
			 
			
			<button class="btn" type="submit">등록 하기</button>
		</form>
	
	</div>

</section>

