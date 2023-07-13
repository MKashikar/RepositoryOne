package com.slb.Springboot_Workout.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.slb.Springboot_Workout.exceptions.CategoryNotFoundExceptioin;
import com.slb.Springboot_Workout.entities.Category;
import com.slb.Springboot_Workout.services.CategoryService;
@RestController
@RequestMapping("/slb/v1/Categories")
public class CategoryController {

	@Autowired
	CategoryService categoryeService;
	
	//**************************Add Category*********************************
	@PostMapping("/")
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ResponseStatus(HttpStatus.OK)
	public void addCategory(@RequestBody Category category) {		
		categoryeService.addCategory(category);
	}
	
	//**************************Fetch Category By ID (Single Category)*********************************
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Category> fetchCategory(@PathVariable ("id") int id) {
		System.out.println("Id" +  id);
		Optional<Category> fetchedCategory = categoryeService.fetchCategory(id);
		
		ResponseEntity<Category> rs = null;
		if(fetchedCategory.isPresent()) {
			rs = new ResponseEntity<Category>(fetchedCategory.get(), HttpStatus.OK);
		}
		else {
			rs = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		}
		return rs;		
	}

	//**************************Fetch All Category (List Of Category)*********************************
		@GetMapping("/")
		@PreAuthorize("hasAnyRole('ADMIN')")
		public ResponseEntity<List<Category>> fetchAllCategory() {
			List<Category> CategoryList = categoryeService.fetchAllCategory();
			
			ResponseEntity<List<Category>> rs = null;
			if(CategoryList.size() > 0) {
				rs = new ResponseEntity<List<Category>>(CategoryList, HttpStatus.OK);
			}
			else {
				rs = new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
			}
			return rs;		
		}
		
		//**************************Apply Patch On Category By Id *********************************
		@PatchMapping("/")
		@PreAuthorize("hasAnyRole('ADMIN')")
		public ResponseEntity<Category> updateCategoryByID(@RequestBody Category category) {
			System.out.println("Category : "+ category);		
			ResponseEntity<Category> rs = null;
			
			//First find already existing object
			int id = category.getId();
			Optional<Category> fetchedCategory = categoryeService.fetchCategory(id);
			
			//If Object is present update the values and save it again
			if(fetchedCategory.isPresent()) {
				Category updatedCatecogry = fetchedCategory.get();
				updatedCatecogry.setCategoryName(category.getCategoryName());
				categoryeService.addCategory(updatedCatecogry);
				rs = new ResponseEntity<Category>(HttpStatus.OK);
			}
			else {
				rs = new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
			}
			return rs;
		}

		//************************* Delete Employee *********************
		@DeleteMapping("/{id}")
		@PreAuthorize("hasAnyRole('ADMIN')")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteEmployee(@PathVariable("id") int id) {
			try {
				categoryeService.deleteCategoryById(id);
			}
			catch (EmptyResultDataAccessException e) {
				throw new CategoryNotFoundExceptioin("Category not found");
			}
		}
}
