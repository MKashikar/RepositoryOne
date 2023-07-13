package com.slb.Springboot_Workout.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ActiveWorkout {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;	
	LocalDate workoutDate;
	LocalTime startTime;
	LocalTime endTime;
	long totalCaloriesBurn;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	Workout workout;
	String userName;
	
	public ActiveWorkout() {
		// TODO Auto-generated constructor stub
	}

	public ActiveWorkout(LocalDate workoutDate, LocalTime startTime, LocalTime endTime, int totalCaloriesBurn,
			Workout workout, String userName) {
		super();
		this.workoutDate = workoutDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalCaloriesBurn = totalCaloriesBurn;
		this.workout = workout;
		this.userName = userName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getWorkoutDate() {
		return workoutDate;
	}

	public void setWorkoutDate(LocalDate workoutDate) {
		this.workoutDate = workoutDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public long getTotalCaloriesBurn() {
		return totalCaloriesBurn;
	}

	public void setTotalCaloriesBurn(long totalCaloriesBurn) {
		this.totalCaloriesBurn = totalCaloriesBurn;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "ActiveWorkout [id=" + id + ", workoutDate=" + workoutDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", totalCaloriesBurn=" + totalCaloriesBurn + ", workout=" + workout + ", userName="
				+ userName + "]";
	}

}
