package com.ea.neon.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ea.neon.domain.User;
import com.ea.neon.service.UserService;

@Controller
public class UserEditProfileController {

	@ModelAttribute("userEdit")
	public User user() {
		return new User();
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/viewpage", method = RequestMethod.POST)
	public String viewpage() {
		return "viewpage";
	}

	@RequestMapping(value = "/editProfileGet", method = RequestMethod.GET)
	public String editprofile(Model model, @ModelAttribute("userEdit") User user, Principal principal,
			HttpSession session) {
		// User user = userService.findOneByUsername("steve");

		String userName = principal.getName();

		System.out.println(userName);

		// String userName = (String) session.getAttribute("currentUser");

		User currentUser = userService.findOneByUsername(userName);
		// System.out.println("First name: "+ currentUser.getEmail());
		// System.out.println("First name: "+ currentUser.getFirstName());
		model.addAttribute("userE", currentUser);

		return "editprofile";
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String editProfilePost(@ModelAttribute("userEdit") User user) {

		System.out.println(user.getId());

		// User userSteve = userService.findOneByUsername("steve");
		userService.update(user);

		return "viewpage";
	}

}
