package com.slb.Springboot_Workout.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.slb.Springboot_Workout.entities.Category;
import com.slb.Springboot_Workout.repositories.CategoryReposiroty;

@Service
public class CategoryService {
	@Autowired
	CategoryReposiroty categoryReposiroty;

	public void addCategory(Category category) {
		categoryReposiroty.save(category);
		System.out.println();
	}

	public Optional<Category> fetchCategory(int id) {
		Optional<Category> category = categoryReposiroty.findById(id);
		return category;		
	}

	public List<Category> fetchAllCategory() {
		List<Category> categoryList = categoryReposiroty.findAll();
		return categoryList;
	}

	public void deleteCategoryById(int id) {	
		categoryReposiroty.deleteById(id);	
	}
	 

}
