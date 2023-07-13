package com.slb.Springboot_Workout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slb.Springboot_Workout.entities.ActiveWorkout;

@Repository
public interface ActiveWorkoutRepository extends JpaRepository<ActiveWorkout, Integer> {

}
