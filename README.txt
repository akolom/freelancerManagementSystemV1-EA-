Automatic creation of MySQL database named "neon_fms" is configured in ApplicationContext.xml

Instead of populate.sql, we have used InitServiceImpl.java, which uses @PostConstruct method to initialize
the necessary data required to run the project.

We are using JMS messaging, so start activemq.

Login credentials or authentication:
For Freelancer
	username : freelancer
	password : freelancer
For Employer
	username : employer
	password : employer
	
To check authorization,
try accessing following links
-	localhost:8080/FreelanceManagementSystem/employer/addProject.html
-	localhost:8080/FreelanceManagementSystem/freelancer/profile.html

RESTful api
	While adding or updating project by employer, when employer selects category of project, an ajax call 
	is made, which brings json objects of list of skills of that category from server using REST and displays 
	on a dropdown list.
	For editing a project, ajax call is made to get json object of the project from server using REST and is
	displayed in update form.
	
JMS
	When freelancer logins, search project and applies for the project, the request is delegated to JMS queue by 
	the controller, and the listener class will save the modifications to database in background.
	
Email
	When employer views his project list, he can see list of freelancers. He can send email to anyone of them
	by clicking the link. Controller sends an email for the interview.
	When employer selects the freelancer to hire, an email is sent to the freelancer about hiring and the 
	modification is done in database.