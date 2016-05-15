package com.ea.neon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ea.neon.domain.User;
import com.ea.neon.service.UserService;
import com.ea.neon.service.impl.UserServiceImpl;

@Controller
public class HomeController {

	
	
	@RequestMapping({ "/", "/index" })
	public String home() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		UserService userService = (UserService) ctx.getBean("userServiceImpl");
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("john@Doe.com");
		

		userService.save(user);
		return "index";
	}

}
