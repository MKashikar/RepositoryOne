package com.slb.Springboot_Workout.controllers;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.slb.Springboot_Workout.entities.ActiveWorkout;
import com.slb.Springboot_Workout.exceptions.CategoryNotFoundExceptioin;
import com.slb.Springboot_Workout.services.ActiveWorkoutService;

@RestController
@RequestMapping("/slb/v1/activeworkouts")
public class ActiveWorkoutController {
	
	@Autowired
	ActiveWorkoutService activeWorkoutService;
	
	//**************************Add Category*********************************
		@PostMapping("/")
		@ResponseStatus(HttpStatus.OK)
		public void addActiveWorkout(@RequestBody ActiveWorkout activeWorkout) {
			
			System.out.println(activeWorkout);
			activeWorkoutService.addActiveWorkout(activeWorkout);
		}

		//**************************Fetch Active Workout By ID (Single Active Workout)*********************************
		@GetMapping("/{id}")
		public ResponseEntity<ActiveWorkout> fetchActiveWorkout(@PathVariable ("id") int id) {
			System.out.println("Id" +  id);
			Optional<ActiveWorkout> fetchedCategory = activeWorkoutService.fetchActiveWorkout(id);
	
			ResponseEntity<ActiveWorkout> rs = null;
			if(fetchedCategory.isPresent()) {
				rs = new ResponseEntity<ActiveWorkout>(fetchedCategory.get(), HttpStatus.OK);
			}
			else {
				rs = new ResponseEntity<ActiveWorkout>(HttpStatus.NO_CONTENT);
			}
			return rs;		
		}

		//**************************Fetch All ActiveWorkouts (List Of Active Workout)*********************************
		@GetMapping("/")
		public ResponseEntity<List<ActiveWorkout>> fetchAllCategory() {
			List<ActiveWorkout> activeWorkoutList = activeWorkoutService.fetchAllActiveWorkout();
			
			ResponseEntity<List<ActiveWorkout>> rs = null;
			if(activeWorkoutList.size() > 0) {
				rs = new ResponseEntity<List<ActiveWorkout>>(activeWorkoutList, HttpStatus.OK);
			}
			else {
				rs = new ResponseEntity<List<ActiveWorkout>>(HttpStatus.NO_CONTENT);
			}
			return rs;		
		}
		
		
		//**************************Apply Patch On Active Workout By Id *********************************
		@PatchMapping("/")
		public ResponseEntity<ActiveWorkout> updateActiveWorkoutByID(@RequestBody ActiveWorkout activeWorkout) {
			System.out.println("ActiveWorkout : "+ activeWorkout);
			
			ResponseEntity<ActiveWorkout> rs = null;

			//First find already existing object
			int id = activeWorkout.getId();
			Optional<ActiveWorkout> fetchedActiveWorkout = activeWorkoutService.fetchActiveWorkout(id);
			
			//If Object is present update the values and save it again
			if(fetchedActiveWorkout.isPresent()) {
				ActiveWorkout updatedActiveWorkout = fetchedActiveWorkout.get();
				
				updatedActiveWorkout.setEndTime(LocalTime.now());

				//Calculation of Total Calories Burn
				LocalTime start = updatedActiveWorkout.getStartTime();
				System.out.println("start time****************************** : "+ start);
				LocalTime end = updatedActiveWorkout.getEndTime();
				System.out.println("end time****************************** : "+ end);
				long  totalWorkoutTime = updatedActiveWorkout.getStartTime().until(updatedActiveWorkout.getEndTime(), ChronoUnit.MINUTES);
				
				int cbpm = updatedActiveWorkout.getWorkout().getCbpm();
				System.out.println("cbpm****************************** : "+ cbpm);
				
				System.out.println("totalWorkoutTime****************************** : "+ totalWorkoutTime);
				long total_Calories_Burn = totalWorkoutTime*cbpm;				
				updatedActiveWorkout.setTotalCaloriesBurn(total_Calories_Burn);

				activeWorkoutService.addActiveWorkout(updatedActiveWorkout);
				rs = new ResponseEntity<ActiveWorkout>(HttpStatus.OK);
			}
			else {
				rs = new ResponseEntity<ActiveWorkout>(HttpStatus.NO_CONTENT);
			}
			return rs;
		}

		//************************* Delete Active Workout *********************
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteEmployee(@PathVariable("id") int id) {
			try {
				activeWorkoutService.deleteActiveWorkoutById(id);
			}
			catch (EmptyResultDataAccessException e) {
				throw new CategoryNotFoundExceptioin("Active Workout not found");
			}
		}
}
