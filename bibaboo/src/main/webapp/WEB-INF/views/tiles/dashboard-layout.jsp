<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,, initial-scale=1">
		
		<title> <tiles:insertAttribute name="title"/> </title>
		
		<link rel="stylesheet" href="/bibaboo/css/layout.css">
		<link rel="stylesheet" href="/bibaboo/css/dashboard-aside.css">
		<link rel="stylesheet" href="/bibaboo<tiles:getAsString name="body-css"/>" >
		
	</head>
	<body>
	
		<div class="wrap">
			
			<!-- header -->
			<tiles:insertAttribute name="header"/>
			
			<!-- aside -->
			<tiles:insertAttribute name="aside"/>
			
			<!-- body -->
			<section>
				<tiles:insertAttribute name="body"/>
			</section>
			
			<!-- footer -->
			<tiles:insertAttribute name="footer"/>			
			
		</div>
	
	</body>
</html>