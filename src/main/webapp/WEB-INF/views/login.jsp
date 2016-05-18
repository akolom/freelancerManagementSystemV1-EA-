<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/import/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Signin</title>
<%@ include file="/WEB-INF/import/links.jsp"%>
</head>
<body>


	<p>Hello This is Login Page</p>


	<%-- <form method = "post" action="/postLogin.html" cssClass="form-signin">
  			<fieldset>
  			<h2 class="form-signup-heading">Signin</h2>
  			<label for = "userNameInput">UserName</label>
  			<input name = "userName" cssClass="form-control" placeholder = "userName">
  			
  			<label for = "password">Password</label>
  			<input name = "password" cssClass="form-control" placeholder = "password">
  			<button name="Button" type = "button">Sing in</button>
  			</fieldset>
  			</form> --%>

	<form action='<spring:url value="/login"/>' method="post">

		<h1>SIGN IN PAGE</h1>



		<input type="text" name="userName" placeholder="User Name"><br>
		<input type="password" name="password" placeholder="Password"><br>
		<input type="submit" tabindex="5" value="Sign In">
	</form>
</body>
</html>

