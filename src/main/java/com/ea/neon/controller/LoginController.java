package com.ea.neon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("currentUser")
public class LoginController {

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/errorpage", method = RequestMethod.POST)
	public String errorPage(Model model) {

		model.addAttribute("message", "Please Try Again To Authenticate: ");
		return "errorpage";
	}

}
