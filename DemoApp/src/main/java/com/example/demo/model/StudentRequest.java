package com.example.demo.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class StudentRequest {
	
	@NotBlank(message = "First name is required")
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
}
