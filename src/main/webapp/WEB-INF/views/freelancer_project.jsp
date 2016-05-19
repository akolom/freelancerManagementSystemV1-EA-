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
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="<spring:url value="/projects/all.html"/>">NEON</a>
		</div>

		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">

				<li><a href="<spring:url value="/projects/all.html"/>">Projects</a></li>
				<li><a
					href="<spring:url value="/freelancer/profile.html?id=5"/>">Profile</a></li>
				<li class="active"><a href="#">Applied Projects</a></li>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:if test="${!empty listProject}">

		<c:forEach items="${listProject}" var="project">
			<div class="row">


				<div class="col-lg-1"></div>

				<div class="col-lg-1">${project.name}</div>

				<div class="col-lg-3">${project.description}</div>

				<div class="col-lg-2">${project.category.categoryTitle.text}</div>

				<div class="col-lg-1">
					<c:forEach items="${project.category.skills}" var="skills">
					${skills.skillTitle.text}<br>
					</c:forEach>
				</div>

				<div class="col-lg-1">${project.budget}</div>

				<div class="col-lg-1">

					<h4>
						<span class="label label-default">
							${project.status.projectStatus.text}</span>&nbsp;&nbsp;

					</h4>

				</div>

			</div>
			<hr>
		</c:forEach>
	</c:if>
					<%@ include file="/WEB-INF/import/footer.jsp"%>
</body>
</html>