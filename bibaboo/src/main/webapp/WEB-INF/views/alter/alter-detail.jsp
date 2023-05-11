<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="card">
		<div class="row" style="width:100%; margin-left:auto; margin-right: auto;">
			
			<div class="alter_img" style="  width:30%; ">
					
				<img src="/bibaboo/img/bag.jpg" alt="alternations_image" >
					
				<div class="card-body" style="text-align: center;">
					   <p class="card-text"><h3>상호명</h3></p>
				</div>
			</div>
				
				
			<div class="alter_detail" style="width:68%; margin-left: 2%">
				
				<div style="  width:100%; margin-top: 50px; ">
					<div style="text-align: center;">
						<p class="card-text"><h5>스토어 정보</h5></p>
					</div>
					<div style=" width:90%; margin-left:auto; margin-right:auto; margin-top: 30px;">
						<p class="card-text"><h4>상호:</h4></p>
						<p class="card-text"><h4>주소:</h4></p>
						<p class="card-text"><h4>전화번호:</h4></p>
						<p class="card-text"><h4>영업 시간:</h4></p>
						<p class="card-text"><h4>평균 별점: 점</h4></p>
					</div>
				</div>
			</div>
		</div>
		
		<div class="writereview" >
			<!--====================별점==================================  -->
			<div style="width:100%; margin-top: 30px">
				<div style=" margin-left: 4%;">
					<h3>소중한 이용후기를 남겨주세요:)</h3>
				</div>
				<form action="/webproject/review/insert.do" method="post">
					<div style="text-align: center;">
						<input type="hidden" name="id" value="jang"/>
						<input type="hidden" name="str_code" value=""/>
						<input type="hidden" name="area" value=""/>
						<input type="hidden" name="storeName" value=""/>
						
						<div class="row">
							<div class="reviewcategory col-sm-3" style=" margin-left: 4%; margin-right: 38%;">
								<select name="category" class="form-control">
									<!-- <option value="바지">바지</option>
									<option value="셔츠">셔츠</option>
									<option value="정장">정장</option>
									<option value="아우터">아우터</option>
									<option value="청바지">청바지</option>
									<option value="치마">치마</option>
									<option value="원피스">원피스</option>
									<option value="리폼">리폼</option> -->
									<option value="pants">바지</option>
									<option value="shirts">셔츠</option>
									<option value="suit">정장</option>
									<option value="outer">아우터</option>
									<option value="jeans">청바지</option>
									<option value="skirt">치마</option>
									<option value="dress">원피스</option>
									<option value="reform">리폼</option>
								</select>
							</div>
							<div class="star-rating space-x-4 mx-auto">
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
						
						<!-- <input type="text"  name="area" placeholder="리뷰" onfocus="this.value=''" style="height: 100px;width: 95%;"> -->
						<textarea rows="5" cols="100" name="content"></textarea>
						<input type="submit" value="등록" style="height: 30px; ">
					</div>
				</form>
			</div>
		</div>
		
		
		<div class="reviewlist">
			<br>
			<div style="text-align: center;"> <h5>신데델라들의 생생후기!</h5> </div>
			
			<div class="star-ratings">
				<div 
			    class="star-ratings-fill space-x-2 text-lg"
			    :style="{ width: ratingToPercent + '%' }"
				>
					<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
				</div>
				<div class="star-ratings-base space-x-2 text-lg">
					<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
				</div>
			</div>
			
			<hr>
			
				<div class ="row" style="width:100%">
					<div style="width:10%; text-align: center"> 점 </div>
					<div style="width:55%">좋아</div>
					<%-- <div style="width:20%; text-align: right;">아이디 : <%=review.getId() %> </div> --%>
					<div style="width:20%; text-align: right;">익명의 신데렐라 </div>
					<div style="width:15%; text-align: right;">작성일 </div>
				</div>
			<hr>
			
		</div>
		
		
	</div>
	
	
	

</section>