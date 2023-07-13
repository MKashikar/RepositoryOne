package com.slb.Springboot_Workout.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.slb.Springboot_Workout.entities.User;
import com.slb.Springboot_Workout.repositories.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	
	@Autowired
	UserRepo userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
		
		System.out.println(user);

		return UserDetailsImpl.build(user);
	}
}
