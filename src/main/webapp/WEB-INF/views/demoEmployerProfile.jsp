<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/import/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employer's Profile</title>
<%@ include file="/WEB-INF/import/links.jsp"%>
</head>
<body>

	<div class="container">
		<div class="row">
			<h1>Personal Information</h1>
			<div class="col-lg-8">
				<div class="row">
					<div class="col-md-4 text-primary">First Name</div>
					<div class="col-md-4"></div>
					<div class="col-md-4">${currentUser.firstName }</div>
				</div>
				<div class="row">
					<div class="col-md-4 text-primary">Last Name</div>
					<div class="col-md-4"></div>
					<div class="col-md-4">${currentUser.lastName }</div>
				</div>
				<div class="row">
					<div class="col-md-4 text-primary">Contact</div>
					<div class="col-md-4"></div>
					<div class="col-md-4">${currentUser.contact }</div>
				</div>
				<div class="row">
					<div class="col-md-4 text-primary">Email</div>
					<div class="col-md-4"></div>
					<div class="col-md-4">${currentUser.email }</div>
				</div>
				<div class="row">
					<h1>Professional Profile</h1>
					<div class="row">
						<div class="col-lg-4 text-primary">Professional Headline</div>
						<div class="col-lg-8">${currentUser.profile.professionalHeadLine }</div>
					</div>
					<div class="row">
						<div class="col-lg-4 text-primary">Profile Summary</div>
						<div class="col-lg-8">${currentUser.profile.profileSummary }</div>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="row center-block">
					<a href='<spring:url value="/employer/editProfile.html"/>'
						class="btn btn-primary">Edit Profile</a>
				</div>
				<br> <br>
				<div class="row">
					<div class="col-lg-6 text-primary">Project Completed</div>
					<div class="col-lg-6">${currentUser.projectCompleted }</div>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<%-- 			<a href='<spring:url value="/employer/addProject.html"/>'
				class="btn btn-primary">Add Project</a> <a
				href='<spring:url value="/employer/getProjectList.html"/>'
				class="btn btn-primary">View Project List</a> --%>
			<div>
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#addProject"
						aria-controls="addProject" role="tab" data-toggle="tab">Add
							Project</a></li>
					<li role="presentation"><a href="#viewProjectList"
						aria-controls="viewProjectList" role="tab" data-toggle="tab">View
							Project List</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="addProject">
						<br>
						<form:form commandName="newProject" method="post"
							action="/FreelanceManagementSystem/employer/addProject.html"
							cssClass="form-horizontal">
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">Project
									Name</label>
								<div class="col-sm-10">
									<form:input path="name" cssClass="form-control"
										placeholder="Project1" />
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-sm-2 control-label">Project
									Description</label>
								<div class="col-sm-10">
									<form:textarea path="description" cssClass="form-control"
										placeholder="This project deals with ...." />
								</div>
							</div>
							<div class="form-group">
								<label for="budget" class="col-sm-2 control-label">Project
									Budget</label>
								<div class="col-sm-10">
									<form:input path="budget" cssClass="form-control"
										placeholder="100.00 $" />
								</div>
							</div>
							<div class="form-group">
								<label for="category" class="col-sm-2 control-label">Project
									Category</label>
								<div class="col-sm-10">
									<form:select cssClass="selectpicker" path="category"
										items="${categories }" itemLabel="id" itemValue="id" />
								</div>
							</div>
							<div class="form-group">
								<label for="skills" class="col-sm-2 control-label">Project
									Skills</label>
								<div class="col-sm-10">
									<form:select cssClass="selectpicker" path="category.skills"
										items="${skills }" itemLabel="skillTitle" itemValue="id"
										multiple="true" size="3"></form:select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-default">Add
										Project</button>
								</div>
							</div>
						</form:form>
					</div>
					<div role="tabpanel" class="tab-pane" id="viewProjectList">
						<c:forEach items="${currentUser.project}" var="project">
							<div class="row panel-body">
								<div class="col-md-6 text-primary">Project Name</div>
								<div class="col-md-6">${project.name}</div>
								<div class="row">
									<c:forEach items="${project.freelancers }" var="freelancer">
										<div class="col-lg-2"></div>
										<div class="col-lg-6">${freelancer.firstName }</div>
										<div class="col-lg-4"></div>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTabs a').click(function(e) {
				e.preventDefault()
				$(this).tab('show')
			});
		});
	</script>

</body>
</html>