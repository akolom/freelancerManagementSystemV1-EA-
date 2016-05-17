package com.ea.neon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ea.neon.domain.Project;
import com.ea.neon.domain.User;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping({ "/", "/index" })
	public String home() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@Doe.com");
		

		userService.save(user);
		return "welcome";
	}

}
