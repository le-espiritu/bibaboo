<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content">

	<div class="card title">
		<p>${top5Response.areaKeyword} ${top5Response.categoryName} 수선 TOP5</p>
	</div>

	<div class="card">
	
		<c:forEach items="${top5Response.alterTop5List}" var="alterations" varStatus="status">
			<section class="tops" >
				<input type="hidden" class="alter-id-input" value="${alterations.id}">
				<div>
					<img src="/bibaboo/img/upload/${alterations.photoName}" alt="alternations_image"/>
				</div>
					
				<div>
					<div>
						<h2>${top5Response.areaKeyword} </h2>
						<h1>NO.${status.index+1} ${top5Response.categoryName} 수선 맛집!</h1>
						
						<div>
							<h4>상호: ${alterations.name}</h4>
							<h4>주소: ${alterations.address }</h4>
							<%-- <p class="card-text"><h4>평균 별점: <%=top1store.getScore() %>점</h4></p> --%>
						</div>
					</div>
				</div>
			</section>
		</c:forEach>
	
	</div>

</section>

<script src="/bibaboo/js/alter/top5.js"></script>