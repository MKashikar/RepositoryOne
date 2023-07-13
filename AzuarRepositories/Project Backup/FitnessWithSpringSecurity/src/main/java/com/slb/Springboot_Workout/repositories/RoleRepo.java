package com.slb.Springboot_Workout.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slb.Springboot_Workout.entities.ERole;
import com.slb.Springboot_Workout.entities.Role;



public interface RoleRepo extends JpaRepository<Role, Long>{

	Optional<Role> findByName(ERole role);
}
