<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="/WEB-INF/import/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SinUp</title>
<%@ include file="/WEB-INF/import/links.jsp"%>
</head>
<body>

<p>Sin up Form</p>

	
      <form class="form-signup" action="<spring:url value="/postSignup"></spring:url>" method="post">
      <!-- <sec:csrfInput /> -->
                    <fieldset>
        <h2 class="form-signup-heading">Please sign up</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        
         <label for="userName" class="sr-only">User Name</label>
        <input type="userName" id="userName" class="form-control" placeholder="User Name" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        
        <div class="checkboxemployer">
          <label>
            <input type="checkbox" value="remember-me"> I want Hire
          </label>
          
        </div>
        <div class = "checkboxfreelancer">
        <label>
            <input type="checkbox" value="remember-me"> I want work
          </label></div>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
     	  	
			    	</fieldset>
			      	</form>

</body>
</html>