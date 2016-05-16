package com.ea.neon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.authentication.UserCredentials;

import com.ea.neon.domain.Credentials;
import com.ea.neon.repository.CredentialsRepository;
import com.ea.neon.service.CredentialService;

public class CredentialServiceImpl implements CredentialService{
	
	/*
	@Autowired
	private CredentialsRepository credentialRepository;
	
	

	
	@Override
	public void save(Credentials credentials) {
		credentialRepository.save(credentials);
		
	}

*/

	@Override
	public Credentials findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
