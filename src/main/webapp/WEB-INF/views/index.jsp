<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/import/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index Page</title>
<%@ include file="/WEB-INF/import/links.jsp"%>
</head>
<body>

	<div class="container">
		<h1>Welcome Neons</h1>
		
		<a href="<spring:url value='/login.html' />" class="btn btn-default pull-right"> Login</a>
		<a href="<spring:url value='/signup.html' />" class="btn btn-default pull-right"> SignUP</a>
	</div>

</body>
</html>