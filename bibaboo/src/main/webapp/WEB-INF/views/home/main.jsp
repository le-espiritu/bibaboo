<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="main_content" style="background-color: red; ">
		<div class="img_section" >
			<img alt="bibaboo_main_image" src="/bibaboo/img/bibaboo.gif" >
		</div>
		<div class="phrase_section">
			<h2>옷장속에 잠들어 있는 오래된 옷들!</h2>
			<br>
			<h2>사이즈가 맞지 않아 한번도 입지 않은 새 옷들!</h2>
			<br>
			<h2>모두 BIbidi Babidi BOO!</h2>
		</div>
	</div>
	
	<div style="text-align: center; margin-top: 20px; margin-bottom: 20px;">
		<h2>지금 근처의 가장 솜씨 좋은 수선집을 한눈에 확인하세요!</h2>
	</div>
	
	<div style="text-align: center; padding-top: 15px" >
		<form action="/webproject/map/area_list.do" method="post">
			<input type="text"  name="area" placeholder="주소로 검색하세요" onfocus="this.value=''" style="height: 40px;width: 350px; text-align: center; color : gray">
			<input type="submit" value="검색" style="height: 40px;">
		</form>
	</div>
	
	<nav style="margin-top: 15px; background-color: #020D42">
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