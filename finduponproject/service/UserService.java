package com.finduponproject.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.finduponproject.model.User;

public interface UserService extends UserDetailsService
{
	User findByEmail(String email);
	
	User save(User user);

}
