package com.ea.neon.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ea.neon.service.CredentialService;

@Controller
@SessionAttributes("currentUser")
public class LoginController {

	@Autowired
	private CredentialService credentialsService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		

		return "login";
	}


	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public String login(@RequestParam("userName")String userName, Model model ) {
		
		model.addAttribute("currentUser", userName);

		return "login";
	}
	
	

	@RequestMapping(value = "/errorpage", method = RequestMethod.POST)
	public String errorPage(Model model) {
		
		model.addAttribute("message", "Please Try Again To Authenticate: ");
		return "errorpage";
	}

	

}
