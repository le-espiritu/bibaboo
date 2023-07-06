<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주문자 정보</title>
	
	<link rel="stylesheet" href="/bibaboo/css/popup/review/review-update-popup-view.css">
</head>
<body>

	<div class="write-box" >
		
		<h3>주문자 정보 팝업 </h3>
		
		<div>
			<h4>주문자 아이디 : ${ordererInfoDTO.email}</h4>
			<h4>주문자 성명 : ${ordererInfoDTO.name}</h4>
			<h4>주문자 연락처 : ${ordererInfoDTO.phoneNumber}</h4>
		</div>
		
	</div>

</body>
</html>