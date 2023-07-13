package com.slb.Springboot_Workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slb.Springboot_Workout.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Boolean existsByEmail (String email);

	public User findByEmail(String email);

}