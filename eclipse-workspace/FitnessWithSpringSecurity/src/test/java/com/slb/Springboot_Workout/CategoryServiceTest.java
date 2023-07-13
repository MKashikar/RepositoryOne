package com.slb.Springboot_Workout;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import com.slb.Springboot_Workout.entities.Category;
import com.slb.Springboot_Workout.services.CategoryService;

@SpringBootTest
class CategoryServiceTest {
	
	@Autowired
	CategoryService categoryService;
	TestEntityManager entityManager;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testFetchAllCategories() {
		
		//create test data
		Category cardio = new Category("Cardio");
		Category weight = new Category("Weight");
		Category strength = new Category("Strength");
		entityManager.persist(cardio);
		entityManager.persist(weight);
		entityManager.persist(strength);
		entityManager.flush();
		
	}

	@Test
	void testAddCategory() {
		
		Category category = new Category("Cardio");
		categoryService.addCategory(category);
	}

	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
}
