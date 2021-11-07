package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	@GetMapping("/getAddress")
	public String getAddress() {
		logger.error("inside error");
		logger.warn("inside warning");
		logger.info("inside info");
		logger.debug("inside debug");
		logger.trace("inside trace");
		return "This is address of student";
	}
}
