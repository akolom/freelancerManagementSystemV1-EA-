package com.ea.neon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SinUpController {
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String sinup() {
 		return "sinup";
	}
	
	@RequestMapping(value="/postSignup", method = RequestMethod.POST)
	public String postSignup(){
		
		
		return null;
		
	}

}
