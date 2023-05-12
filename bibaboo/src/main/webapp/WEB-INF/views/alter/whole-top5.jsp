<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<section class="area-search">
		<div>
			<p>우리동네 top5가 알고 싶다면?</p>
		</div>
	
		<div>
			<form action="/webproject/shop/shop_areatop5.do" method="get">
				<input type="hidden" name="category" value="">
				<input type="text"  name="area" placeholder="여기서 검색하세요!   ex)강남구 삼성동" onfocus="this.value=''">
				<input type="submit" value="검색">
			</form>
		</div>
	</section>

	<div class="card">
	
		<section class="title">
			<p>전국 정장 수선 TOP5</p>
		</section>
	
		<section class="tops" >
			<div style="  width:35%; ">
				<a href="#">
					<img src="/bibaboo/img/bag.jpg" alt="alternations_image"/>
				</a>
			</div>
				
			<div>
				<div>
					<h2>강남구 삼성동 </h2>
					<h1>NO.1 드레스 수선 맛집!</h1>
					
					<div style="margin-top: 30px;">
						<h4>상호:</h4>
						<h4>주소:</h4>
						<%-- <p class="card-text"><h4>평균 별점: <%=top1store.getScore() %>점</h4></p> --%>
					</div>
				</div>
			</div>
		</section>
	
	</div>

</section>