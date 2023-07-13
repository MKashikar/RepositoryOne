package com.slb.Springboot_Workout.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String categoryName;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}

	

}
