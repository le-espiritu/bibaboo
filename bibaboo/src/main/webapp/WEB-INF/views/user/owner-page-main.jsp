<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="card">
	<h1><sec:authentication property="principal.username"/> 님</h1>
	<h1>수선집 관리 페이지 </h1>
	<%-- <h1>password : <sec:authentication property="principal.password"/> </h1> --%>
</div>

