package com.ea.neon.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ea.neon.dao.UserDao;
import com.ea.neon.domain.User;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class );
		}

	public User findByEmail(String email) {
	     
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
			     

	}
	
	


 }