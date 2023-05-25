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

</section>