<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="login-card">
		<form action="/webproject/menu/login.do" method="post">
		  <h2>Login</h2>
		  <div class="idForm">
		    <input type="text" name="email" placeholder=" email" value="" >
		  </div>
		  <div class="passForm">
		    <input type="password" name="pass" placeholder=" password" >
		  </div>
		  
		  <button type="submit" class="btn" value="LOG IN">
		    LOG IN
		  </button>
		</form>
		
		  
		<div class="bottom-text">
		  <p>아직 회원이 아니신가요? <a href="/webproject/joinPage.do">가입하기</a></p>
		  <p>업체 등록 및 가입 <a href="/webproject/shop_joinPage.do">가입하기</a></p>
		  <p>업체 로그인 <a href="/webproject/shop_loginpage.do">로그인</a></p>
		</div>
	</div>

</section>
