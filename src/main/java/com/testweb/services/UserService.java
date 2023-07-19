package com.testweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.testweb.model.UserLog;
import com.testweb.repo.IUserRepo;
import java.util.*;
import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private IUserRepo userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLog user = userRepository.findByName(username); 
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDetails = new User(user.getName(), user.getPassword(), roles);
		
		return userDetails;
	}
}
