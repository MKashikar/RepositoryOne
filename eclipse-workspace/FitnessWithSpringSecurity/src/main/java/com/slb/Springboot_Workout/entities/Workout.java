package com.slb.Springboot_Workout.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String workoutTitle;
	int cbpm;
	String description;	
	@ManyToOne
	Category category;
	
	String media;
	
	public Workout() {
		// TODO Auto-generated constructor stub
	}
	public Workout(String workoutTitle, int cbpm, String description, Category category, String media) {
		super();
		this.workoutTitle = workoutTitle;
		this.cbpm = cbpm;
		this.description = description;
		this.category = category;
		this.media = media;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkoutTitle() {
		return workoutTitle;
	}

	public void setWorkoutTitle(String workoutTitle) {
		this.workoutTitle = workoutTitle;
	}

	public int getCbpm() {
		return cbpm;
	}

	public void setCbpm(int cbpm) {
		this.cbpm = cbpm;
	}

	public String getDescription() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "Workout [id=" + id + ", workoutTitle=" + workoutTitle + ", cbpm=" + cbpm + ", description=" + description
				+ ", category=" + category + ", media=" + media + "]";
	}
	
	

}
