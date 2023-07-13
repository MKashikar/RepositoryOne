package com.slb.Springboot_Workout.services;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.slb.Springboot_Workout.entities.ActiveWorkout;
import com.slb.Springboot_Workout.entities.Workout;
import com.slb.Springboot_Workout.exceptions.WorkouNotFoundException;
import com.slb.Springboot_Workout.repositories.ActiveWorkoutRepository;
import com.slb.Springboot_Workout.repositories.WorkoutRepository;

@Service
public class ActiveWorkoutService {

	@Autowired
	ActiveWorkoutRepository activeWorkoutRepository;
	@Autowired
	WorkoutRepository workoutRepository;

	@ResponseStatus(HttpStatus.CREATED)
	public void addActiveWorkout(ActiveWorkout activeWorkout) {
		
		activeWorkout.setWorkoutDate(LocalDate.now());
		activeWorkout.setStartTime(LocalTime.now());
		//activeWorkout.setEndTime(LocalTime.now());
		
		int workoutID = activeWorkout.getWorkout().getId();
		System.out.println(workoutID);
		Optional<Workout> workout = workoutRepository.findById(workoutID);
		System.out.println(workout.get());
		if(workout.isPresent()) {		
			activeWorkout.setWorkout(workout.get());
		}
		else {
			throw new WorkouNotFoundException("Workout Not Found");
		}
		activeWorkoutRepository.save(activeWorkout);
	}

	public Optional<ActiveWorkout> fetchActiveWorkout(int id) {
		Optional<ActiveWorkout> fetchedActiveWoprkout = activeWorkoutRepository.findById(id);
		return fetchedActiveWoprkout;
	}

	public List<ActiveWorkout> fetchAllActiveWorkout() {
		List<ActiveWorkout> activeWorkoutList = activeWorkoutRepository.findAll();
		return activeWorkoutList;
	}

	public void deleteActiveWorkoutById(int id) {
		activeWorkoutRepository.deleteById(id);		
	}
	

}
