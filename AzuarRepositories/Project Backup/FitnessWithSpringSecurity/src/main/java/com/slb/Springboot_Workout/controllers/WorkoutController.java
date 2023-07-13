package com.slb.Springboot_Workout.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.slb.Springboot_Workout.entities.Workout;
import com.slb.Springboot_Workout.services.WorkoutService;

@RestController
@RequestMapping("/slb/v1/workouts")
public class WorkoutController {
	
	
	@Autowired
	WorkoutService workoutService;
	
	//**************************Add Category*********************************
	@PostMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public void addCategory(@RequestBody Workout workout) {		
		workoutService.addWorkout(workout);
	}
	
	//**************************Fetch Workout By ID (Single Workout)*********************************
		@GetMapping("/{id}")
		public ResponseEntity<Workout> fetchWorkout(@PathVariable ("id") int id) {
			System.out.println("Id" +  id);
			Optional<Workout> fetchedWorkout = workoutService.fetchWorkout(id);
			
			ResponseEntity<Workout> rs = null;
			if(fetchedWorkout.isPresent()) {
				rs = new ResponseEntity<Workout>(fetchedWorkout.get(), HttpStatus.OK);
			}
			else {
				rs = new ResponseEntity<Workout>(HttpStatus.NO_CONTENT);
			}
			return rs;		
		}

}
