package com.slb.Springboot_Workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slb.Springboot_Workout.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
