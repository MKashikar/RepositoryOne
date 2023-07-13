package com.slb.Springboot_Workout.exceptions;

public class CategoryNotFoundExceptioin extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;

	public CategoryNotFoundExceptioin(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
