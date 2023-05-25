<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="main_content">
		<div class="img_section" >
			<img alt="bibaboo_main_image" src="/bibaboo/img/bibaboo.gif" >
		</div>
		<div class="phrase_section">
			<p>옷장속에 잠들어 있는 오래된 옷들!</p>
			<br>
			<p>사이즈가 맞지 않아 한번도 입지 않은 새 옷들!</p>
			<br>
			<p>모두 BIbidi Babidi BOO!</p>
		</div>
	</div>
	
	
	<section>
		<div>
			<h2>지금 근처의 가장 솜씨 좋은 수선집을 한눈에 확인하세요!</h2>
		</div>
		
		<div>
			<form action="/bibaboo/alterations" method="GET">
				<input type="hidden" name="pageNum" value=1>
				<input type="hidden" name="amount" value=8>
				<input type="hidden" name="type" value="A">
				<input type="text"  name="keyword" placeholder="주소로 검색하세요" onfocus="this.value=''" >
				<input type="submit" value="검색" >
			</form>
		</div>
	</section>
	
	
	<nav>
		<section>
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">전국<br>바지수선<br>TOP5 </a>
			</div>
			
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
			
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
			
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
		</section>
		
		<section>
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
			
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
			
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
			
			<div class="tob-box"> 
				<a href="/webproject/shop/shop_top5.do?category=pants">바지수선<br>TOP5 </a>
			</div>
		</section>
	</nav>
	
</section>