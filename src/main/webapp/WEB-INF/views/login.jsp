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


	

	 <form action='<spring:url value="/login"/>' method="post"> 
	 
	 
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUserName" class="sr-only">userName</label>
        <input type="text" name="userName" id="inputUserName" class="form-control" placeholder="userName" >
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      
	<%-- <%-- <form action="/loginpage.html" method="post"> --%>
	
	
<!-- 
		<h1>SIGN IN PAGE</h1>



		<input type="text" name="userName" placeholder="UserName"><br>
		<input type="password" name="password" placeholder="Password"><br>
		<input type="submit" tabindex="5" class="btn btn-lg btn-primary btn-block" value="Sign In"> --%> -->
	</form>
</body>
</html>

