package com.ea.neon.service;

import com.ea.neon.domain.Credentials;

public interface CredentialService {
	
	//public void save(Credentials credentials);
	public Credentials findByUserName(String userName);

}
