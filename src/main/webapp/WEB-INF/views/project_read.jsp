<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/import/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects</title>
<%@ include file="/WEB-INF/import/links.jsp"%>
</head>
<body>
<br>
<br>
	<span id="a"></span>
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-3" >
			<div class="row">
				<form:form commandName="projectSearch" method="post"
					action='/FreelanceManagementSystem/projects/filterSearch.html'>
					<form:select path="category" items="${category}"
						itemLabel="categoryTitle.text" itemValue="id"
						cssClass="selectpicker">
					</form:select>
					<br>
					<br>
					<form:select path="skills" items="${skill}"
						itemLabel="skillTitle.text" itemValue="id" multiple="true"
						cssClass="selectpicker">
					</form:select>
					<br>
					<br>
					<h4>
						Fixed Price <span class="label label-default">Less Than</span>
					</h4>
					<form:select path="maxBudget" cssClass="selectpicker">
						<form:option value="100">&#36; 100</form:option>
						<form:option value="1000">&#36; 1000</form:option>
						<form:option value="10000">&#36; 10000</form:option>
						<form:option value="100000">&#36; 100000</form:option>
						<form:option value="1000000">&#36; 1000000</form:option>
					</form:select>
					<br>
					<br>
					<input type="submit" class="btn btn-default" value="Search">
				</form:form>

			</div>
		</div>
		<div class="col-lg-7">
			<div class="row">
				<div class="col-lg-8">
					<form action="<spring:url value="/projects/search.html" />"
						method="get">
						<div class="input-group">
							<input type="text" name="search" class="form-control"
								placeholder="Search for Projects"> <span
								class="input-group-btn"> <input type="submit"
								class="btn btn-default" value="Go!">
							</span>

						</div>
					</form>
				</div>
				<div class="col-lg-4">
					<br>
				</div>
			</div>
			<hr>
			<c:if test="${!empty listProject}">

				<c:forEach items="${listProject}" var="project">
					<div class="row">
						<div class="col-lg-8">
							${project.name} <br> ${project.description}<br>
							${project.category.categoryTitle.text}<br>
							<c:forEach items="${project.category.skills}" var="skills">
					${skills.skillTitle.text}<br>
							</c:forEach>
							<br>
						</div>
						<div class="col-lg-4">


							<a href='<spring:url value="/projects/applyProject.html?id=${project.id}"/>' 
								class="btn btn-primary">  Apply  </a>  

<<<<<<< HEAD
	<div class="container">
		<h1>Welcome Neons</h1>
		<h1>Succefully Authenticate Congratulation</h1>
=======
							<br>&#36; ${project.budget}<br>


						</div>
					</div>
					<hr>
				</c:forEach>

			</c:if>

		</div>
		<div class="col-lg-2"></div>
>>>>>>> origin/sabeen
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$("#category")
									.on(
											'input',
											function() {
												var val = this.value;

												if ($('#categories')
														.find('option')
														.filter(
																function() {
																	return this.value
																			.toUpperCase() === val
																			.toUpperCase();
																}).length) {
													//send ajax request
													alert(this.value
															+ "    "
															+ document
																	.getElementById("min").value);
												}
											});

						});
	</script>
</body>
</html>