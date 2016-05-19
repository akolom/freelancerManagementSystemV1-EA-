package com.ea.neon.main;

import org.springframework.beans.factory.annotation.Autowired;

import com.ea.neon.domain.User;
import com.ea.neon.service.UserService;

public class Main {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		
		(new Main()).checkMethod();
		
	}
	
	private  void checkMethod(){
		
		User user = userService.findOneByUsername("steve");
		
		System.out.println("FirstName: "+user.getFirstName());
		System.out.println("FirstName: "+user.getLastName());
		System.out.println("FirstName: "+user.getEmail());
	}

}
