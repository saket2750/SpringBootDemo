package com.springboot.demo.error;

public class DepartmentNotFoundException extends Exception{
	
	public DepartmentNotFoundException(String message) {
        super(message);
    }
}
