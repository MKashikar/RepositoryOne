package com.slb.Springboot_Workout.exceptions;

public class WorkouNotFoundException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String errorMessage;
	public WorkouNotFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
