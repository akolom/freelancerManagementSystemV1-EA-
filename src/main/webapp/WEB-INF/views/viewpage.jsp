<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/import/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Profile</title>
<%@ include file="/WEB-INF/import/links.jsp"%>
</head>
<body>


	<h1>Welcome Neons</h1>
	
	
	<p>Please click this link to edit profile<a href="<spring:url value='/editProfileGet.html' />"
		class="btn btn-default pull-right"> edit Profil</a>
	<%-- <a href="<spring:url value='/logout.html' />" class="btn btn-default pull-right"> LogOut</a> --%>
</p>

</body>
</html>