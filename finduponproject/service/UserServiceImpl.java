package com.finduponproject.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.finduponproject.model.Role;
import com.finduponproject.model.User;
import com.finduponproject.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), 
				user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }


	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user){
		User user2 = new User();
		user2.setName(user.getName());
		user2.setEmail(user.getEmail());
		user2.setPassword(passwordEncoder.encode(user.getPassword()));
		user2.setAddress(user.getAddress());
		user2.setNumber(user.getNumber());
		user2.setRoles(Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user2);
	}

}
