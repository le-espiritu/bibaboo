<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,, initial-scale=1">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="/bibaboo/css/layout.css">
		<link rel="stylesheet" href="/bibaboo/css/main.css">
		
	</head>
	<body>
	
		<div class="wrap">
			
			<header>
				<h1>BI BA BOO!</h1>
				
				<nav>
					<ul>
						<li><a href="#">수선집 검색</a></li>
						<li><a href="#">수선 신청</a></li>
					</ul>

					<ul>
						<li><a href="#">로그인</a></li>
					</ul>
				</nav>
			</header>
			
			<section>
				<section class="content">
					<div style="background-color: red; height: 500px;">
						사진
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
					
					<div style="margin-top: 15px; padding-botoom: 15px; background-color: #020D42">
					
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
						
						<div class="tob-box"> 
							<a href="/webproject/shop/shop_top5.do?category=pants"><p>바지수선 TOP5</p> </a>
						</div>
					</div>
					
				</section>
			</section>
			
			<footer>
				<span>bibaboo@bibaboo.com</span>
			</footer>
			
		</div>
	
	</body>
</html>