package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StudentUpdate {
	@NotNull(message = "stduent id is not nil")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}
