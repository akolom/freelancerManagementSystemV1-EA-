package com.ea.neon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ea.neon.domain.Credentials;
import com.ea.neon.service.CredentialService;



@Controller
public class LoginController {
	
@Autowired
private CredentialService credentialsService;


@RequestMapping(value="/login", method = RequestMethod.GET)
public String login(){
	
	return "login";
}


@RequestMapping(value="/postLogin", method = RequestMethod.POST)
public String PostLogin(Credentials credentials, Model model) {

	Credentials validCredentials = credentialsService.findByUserName(credentials.getUserName());

	if (validCredentials == null)
		return  "login";

	model.addAttribute("user", validCredentials.getUser());
		return "redirect:/index";
}


}
