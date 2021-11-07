package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InQueryRequest;
import com.example.demo.model.Student;
import com.example.demo.model.StudentRequest;
import com.example.demo.model.StudentResponse;
import com.example.demo.model.StudentUpdate;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/api/student")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/get")
	public List<StudentResponse> getStudent() {
		logger.error("inside error");
		logger.warn("inside warning");
		logger.info("inside info");
		logger.debug("inside debug");
		logger.trace("inside trace");
 		List<Student> studentsList = studentService.AllStudents();
 		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		logger.info("studentsList: "+studentsList);
 		return studentsRepsonse;
	}
	
	@PostMapping("/add")
	public StudentResponse addStudent(@Valid @RequestBody StudentRequest studentRequest) {
		Student student = studentService.addStudent(studentRequest);
		return new StudentResponse(student);
	}
	@PutMapping("/update")
	public StudentResponse updateStudent(@Valid @RequestBody StudentUpdate studentUpdate) {
		Student st = studentService.updateStudent(studentUpdate);
		return new StudentResponse(st);
	}
//	@DeleteMapping("/delete")
//	public String deleteStudent(@RequestParam Long id) {
//		 return studentService.deleteStudent(id);
//	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		 return studentService.deleteStudent(id);
	}
	@GetMapping("/getByFirstName/{firstName}")
	public List<StudentResponse> getByFirstName(@PathVariable String firstName){
		List<Student> studentsList = studentService.getByFirstName(firstName);
 		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	@GetMapping("/getByFirstNameAndLastName/{firstName}/{lastName}")
	public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName){
		Student st =  studentService.getByFirstNameAndLastName(firstName,lastName);
		return new StudentResponse(st);
	}
	@GetMapping("/getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName,@PathVariable String lastName){
		List<Student> studentsList =  studentService.getByFirstNameOrLastName(firstName,lastName);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	@PostMapping("/getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
		List<Student> studentsList =  studentService.getByFirstNameIn(inQueryRequest);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	@GetMapping("/getAllWithPagination")
	public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
		List<Student> studentsList =  studentService.getAllStudentsWithPagination(pageNo,pageSize);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	@PostMapping("/login/{username}/{password}")
	public String login(@PathVariable String username,@PathVariable String password) {
		return studentService.checkLogin(username,password);
	}
	@GetMapping("/like/{firstName}")
	public List<StudentResponse> like(@PathVariable String firstName){	
		List<Student> studentsList =  studentService.like(firstName);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	
	@GetMapping("/startsWith/{firstName}")
	public List<StudentResponse> startsWith(@PathVariable String firstName){	
		List<Student> studentsList =  studentService.startsWith(firstName);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	@GetMapping("/endsWith/{firstName}")
	public List<StudentResponse> endsWith(@PathVariable String firstName){	
		List<Student> studentsList =  studentService.endsWith(firstName);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
	@PutMapping("updateFirstName/{id}/{firstName}")
	public String updateStudentWithFirstName(@PathVariable Long id, @PathVariable String firstName) {
		return studentService.updateStudentWithFirstName(id, firstName) + "Student's updated";
	}
	@DeleteMapping("deleteByFirstName/{firstName}")
	public String deleteByFirstName(@PathVariable String firstName) {
		return studentService.deleteByFirstName(firstName) + "Student's updated";
	}
	@GetMapping("/getByCity/{city}")
	public List<StudentResponse> getByCity(@PathVariable String city){	
		List<Student> studentsList =  studentService.getByCity(city);
		List<StudentResponse> studentsRepsonse = new ArrayList<StudentResponse>();
 		studentsList.stream().forEach(student -> {
 			studentsRepsonse.add(new StudentResponse(student));
 		});
 		return studentsRepsonse;
	}
}
