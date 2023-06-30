<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="join-card">

		<form action="/bibaboo/user" method="POST" >
			<h2>유저 회원가입</h2> 
			
			<div> 
				<label>이름</label> 
				<input type="text" class="form-control" id="name" name="name" placeholder="이름" required> 
			</div> 
				
			<div>
				<label>이메일</label> 
				<input type="email" class="form-control" id="email"name="email" placeholder="you@example.com" required> 
				<span id="checkVal">${result}</span>
			</div> 
				
			<div> 
				<label>비밀번호</label> 
				<input type="password" class="form-control" id="pass" name="password" placeholder="4자리이상 입력해주세요" required> 
			</div> 
			
			<!-- <div class="col-md-6 mb-3">
				<label for="pass2">비밀번호 확인</label>
				<input type="password" class="form-control" id="pass2" placeholder="동일한 비밀번호 입력" required> 
			</div>  -->
				
			<!-- <div> 
				<label>주소</label> 
				<input type="text" class="form-control" id="addr"  name="addr" placeholder="서울특별시 강남구" required> 
			</div>  -->
				
			<div>
				<label>휴대폰 번호</label>
				<input type="text" class="form-control" id="phone" name="phoneNumber" placeholder="휴대폰 번호를 입력해주세요." required>
			</div> 
			 
			<hr>
			
			<div>
				<input type="checkbox" class="custom-control-input" id="aggrement" required> 
				<label>개인정보 수집 및 이용에 동의합니다.</label> 
			</div> 
			
			<button class="btn" type="submit">가입 하기</button>
		</form>
	
	</div>

</section>



	 
	 
	 <script>
		 window.addEventListener('load', () => {
		 const forms = document.getElementsByClassName('validation-form');
		
		 Array.prototype.filter.call(forms, (form) => {
		  form.addEventListener('submit', function (event) {
		  if (form.checkValidity() === false) { 
		 event.preventDefault();
		 event.stopPropagation();
		 } 
		
		
		form.classList.add('was-validated');
		 }, false);
		 });
		 }, false);
	 </script> 
	 
	 <script type="text/javascript">
		$(document).ready(function(){
	  		$("#email").on("keyup",function(){
	  			
	  			$.get("/webproject/menu/emailcheck.do", {"email":$("#email").val()}, 
	  					function(data){//data는 응답되어 오는 데이터를 자동으로 success란에 명시하는 함수의 매개변수로 전달
	  									$("#checkVal").text(data);}, "text");
	  		});
	  	});
	</script>