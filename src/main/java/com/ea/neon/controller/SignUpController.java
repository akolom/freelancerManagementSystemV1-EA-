package com.ea.neon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		/*model.addAttribute("a"authorityService.findAll() );*/
		//model.addAttribute("authority", authorityService.findAll());
		model.addAttribute("authority", authorityService.findAll());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(@ModelAttribute("user")User user, Model model, BindingResult result) {
		System.out.println("---------------------- Checking signuppost");
		User validUser = userService.findOneByUsername(user.getCredentials().getUserName());

		if (validUser != null) {
			
			model.addAttribute("message", "Your are already In role: Just sign in Please");
			return "errorpage";
		} else {
			
			authorityService.save(user.getCredentials().getAuthority());
			//credentialsService.save(user.getCredentials());
			userService.save(user);
			return "login";
		}

	}
	
	/*@RequestMapping(value = "/signupPos", method = RequestMethod.POST)
	public String signupPost(HttpServletRequest request,HttpServletResponse respnse, ModelMap model){
		
		  Authority authority = new Authority();
		  authority.setRole(request.getParameter("role"));
		  
		  
		  System.out.println("role as = "+ request.getParameter("role"));
		  
		  authority.setName(request.getParameter("fname"));
		  
		  
		  Credentials credential = new Credentials();
		  credential.setUserName(request.getParameter("username"));
		  credential.setPassword(request.getParameter("password"));
		  credential.setVerifyPassword(request.getParameter("verifypassword"));
		 
		  credential.setAuthority(authority);
		  credentialsService.save(credential);
		  
	      User user = new User();
	        
	    	user.setEmail(request.getParameter("email"));
	    	user.setFirstName(request.getParameter("fname"));
			user.setLastName(request.getParameter("lname"));
			user.setContact(request.getParameter("contact"));
			
			
			
			user.setCredentials(credential);
			
			String messageInfo = request.getParameter("fname") +" "+ request.getParameter("lname");
			userService.save(user);
	       
	      
	        System.out.println("Full Name = "+messageInfo);
	        
	        model.addAttribute("message1", messageInfo);
	        
	        return "login";
		
	}
	
*/
}
