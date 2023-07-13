package com.slb.Springboot_Workout.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.slb.Springboot_Workout.entities.Workout;
import com.slb.Springboot_Workout.repositories.WorkoutRepository;


@Service
public class WorkoutService {
	
	@Autowired
	WorkoutRepository workoutRepository;

	public void addWorkout(Workout workout) {
		workoutRepository.save(workout);		
	}

	public Optional<Workout> fetchWorkout(int id) {
		Optional<Workout> workout = workoutRepository.findById(id);
		return workout;
	}
}
