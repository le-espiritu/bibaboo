<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">
			
	<nav>
		
		<%-- <div OnClick="location.href ='/webproject/shop/shop_areatop5.do?category=pants&&area=<%=storelist.get(0).getArea() %>'"style="cursor:pointer; width:12.5%">
			<div class="tob-box"> 
				<p class="top5_p">바지수선 TOP5</p>
			</div>
		</div> --%>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
		<div OnClick="location.href ='#'" >
			<p>${alterationsWithPagingDto.pageDTO.criteria.keyword }<br>바지수선<br>TOP5</p>
		</div>
		
	</nav>

	
	<section class="list-section">
		
		<c:forEach items="${alterationsWithPagingDto.alterList}" var="alterationsDto">
			<section>
				<div class="card" OnClick="location.href='/bibaboo/alterations/${alterationsDto.id}'">
				
					<img src="/bibaboo/img/upload/${alterationsDto.photoName}" alt="alternations_image" >
					
					<div class="card-body">
						<div>
							<p>상호:${alterationsDto.name}</p>
							<p>주소:${alterationsDto.address } </p>
						</div>
					</div>
				</div>
			</section>
		</c:forEach>
		
	</section>
	
	<section class="page-info">
		<form id="alterListMoveForm" method="GET">
			<input type="hidden" name="pageNum" value="${alterationsWithPagingDto.pageDTO.criteria.pageNum}">
			<input type="hidden" name="amount" value="${alterationsWithPagingDto.pageDTO.criteria.amount}">
			<input type="hidden" name="type" value="${alterationsWithPagingDto.pageDTO.criteria.type}">
			<input type="hidden" name="keyword" value="${alterationsWithPagingDto.pageDTO.criteria.keyword}">
		</form>
	
		<ul>
			<!-- 이전 페이지 버튼 -->
			<c:if test="${alterationsWithPagingDto.pageDTO.prev}">
				<li><a href="${alterationsWithPagingDto.pageDTO.startPage-1}">Previous</a></li>
			</c:if>
		
			<c:forEach var="num" begin="${alterationsWithPagingDto.pageDTO.startPage}" end="${alterationsWithPagingDto.pageDTO.endPage}">
				<li class="${alterationsWithPagingDto.pageDTO.criteria.pageNum == num? 'active':'' }"><a href="${num}">${num}</a></li>
			</c:forEach>
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${alterationsWithPagingDto.pageDTO.next}">
				<li><a href="${alterationsWithPagingDto.pageDTO.endpage+1 }">next</a></li>
			</c:if>
		</ul>
	</section>

</section>

<script src="/bibaboo/js/alter/alter-list.js"></script>