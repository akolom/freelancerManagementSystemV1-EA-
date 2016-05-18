package com.ea.neon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ea.neon.service.CredentialService;

import edu.mum.security.AuthenticateUser;

@Controller
public class LoginController {

	@Autowired
	private CredentialService credentialsService;

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String PostLogin(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("PostLogin Invoke:  ........  ");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

		AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		/*
		 * System.out.println("Name: "+name); System.out.println("Password: "
		 * +password); if((name=="akolom")){
		 * 
		 * if((password=="akolom")){
		 * 
		 * 
		 * } System.out.println("View Page Invoke:  ........  "); return
		 * "viewpage"; }
		 * 
		 * else{ request.setAttribute("message",
		 * "Please Sign in with correct user name and Password");
		 * System.out.println("Error Page Invoke:  ........  "); return
		 * "errorpage"; }
		 */

		try {

			Authentication requestUser = new UsernamePasswordAuthenticationToken(name, password);

			System.out.println("requestUser: " + requestUser);
			Authentication result = authenticationManager.authenticate(requestUser);
			System.out.println("Result: " + result);
			SecurityContextHolder.getContext().setAuthentication(result);
			// AuthenticateUser authenticateUser = new AuthenticateUser();

			// authenticateUser.authenticate(authenticationManager, name,
			// password);
			return "viewpage";

		}

		catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("message", "Please Try Again To Authenticate: ");
			return "errorpage";
		}

	}

	@RequestMapping("/errorpage")
	public String errorPage() {
		return "errorpage";
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public String editprofile() {

		return "editprofile";
	}

}
