package com.ea.neon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ea.neon.domain.Authority;
import com.ea.neon.domain.User;
import com.ea.neon.service.AuthorityService;
import com.ea.neon.service.UserService;

@Controller
public class SignUpController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String sinup(Model model) {
		model.addAttribute("authority", authorityService.findAll());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "signup";
		}
		Authority authority = authorityService.findOneByName(user.getCredentials().getAuthority().getName());
		user.getCredentials().setAuthority(authority);
		userService.save(user);
		return "redirect:/";
	}

}
