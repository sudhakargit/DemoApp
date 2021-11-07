package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.AllArgsConstructor;

//@ComponentScan({"com.example.demo.config","com.example.demo.controller","com.example.demo.service"})
@SpringBootApplication
@EnableScheduling
public class DemoAppApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(DemoAppApplication.class, args);
	}

}