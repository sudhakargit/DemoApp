package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StudentResponse {
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	public StudentResponse(Student student) {
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
	}
}

