<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="content">

	<div class="card">
	
		<section class="infor">
			<div class="alter-img">
				<img src="/bibaboo/img/upload/${alterationsDto.photoName}" alt="alternations_image" >
				<div>
					<p>${alterationsDto.name}</p>
				</div>
			</div>
				
			<div class="alter-detail">
				<div>
					<p>수선집 정보</p>
					<div>
						<p>상호 : ${alterationsDto.name }</p>
						<p>주소 : ${alterationsDto.address}</p>
						<p>전화번호 : ${alterationsDto.telNumber}</p>
						<p>영업 시간 : ${alterationsDto.openTime} - ${alterationsDto.closeTime}</p>
						<p>평균 별점: ${alterationsDto.avgScore} 점</p>
					</div>
				</div>
			</div>
		</section>
		
		<section class="order">
			<button class="btn">
				<p>수선 신청 하기</p>
			</button>
		</section>
		
		<section class="write-box" >
			<h3>소중한 이용후기를 남겨주세요:)</h3>
			
			<form action="/webproject/review/insert.do" method="post">
				<input type="hidden" name="id" value="jang"/>
				<input type="hidden" name="str_code" value=""/>
				<input type="hidden" name="area" value=""/>
				<input type="hidden" name="storeName" value=""/>
				
				<div>
					<select name="category">
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
					
					<div class="star-rating">
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
				
				<textarea rows="5" style="width:100%;" name="content"></textarea>
				<div>
					<input type="submit" value="등록">
				</div>
			</form>
		</section>
		
		
		<section class="review-list">
			<div> 
				<h4>신데렐라들의 생생후기!</h4> 
			</div>
			
			<div class="star-ratings">
				<div class="star-ratings-fill">
					<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
				</div>
				<div class="star-ratings-base">
					<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
				</div>
			</div>
			
			<div class ="review">
				<table>
					<thead>
						<tr>
							<th>no</th>
							<th>별점</th>
							<th>리뷰</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>5점</td>
							<td>좋아요</td>
							<td>신데렐라</td>
							<td>작성일</td>
						</tr>
					</tbody>
				</table>
			</div>
		</section>
		
	</div>
	
</section>