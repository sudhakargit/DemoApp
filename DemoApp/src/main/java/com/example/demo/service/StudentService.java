package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.model.InQueryRequest;
import com.example.demo.model.Student;
import com.example.demo.model.StudentRequest;
import com.example.demo.model.StudentResponse;
import com.example.demo.model.StudentUpdate;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;
	
	public Student addStudent(StudentRequest studentRequest) {
		Student student = new Student(studentRequest);
		Address address = new Address();
		address.setStreet(studentRequest.getStreet());
		address.setCity(studentRequest.getCity());
		address = addressRepository.save(address);
		student.setAddress(address);
		student = studentRepository.save(student);
		return student;
	}

	public List<Student> AllStudents() {
		return studentRepository.findAll();
	}

	public Student updateStudent(StudentUpdate studentUpdate) {
		Student st = studentRepository.findById(studentUpdate.getId()).get();

		if (studentUpdate.getFirstName() != null && !studentUpdate.getFirstName().isEmpty()) {
			st.setFirstName(studentUpdate.getFirstName());
		}
		return studentRepository.save(st);
	}

	public String deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return "Student is delete successfully";
	}

	public List<Student> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstName(firstName);
	}

	public Student getByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
//		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
		return studentRepository.getByFirstNameAndLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}

	public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> getAllStudentsWithSorting() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		return studentRepository.findAll(sort);
	}

	public String checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		if (username == password) {
			return "Login is successfull";
		} else {
			return "Login is Fail";
		}
	}

	public List<Student> like(String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameContains(firstName);
	}

	public List<Student> startsWith(String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameStartsWith(firstName);
	}
	public List<Student> endsWith(String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.findByFirstNameEndsWith(firstName);
	}

	public Integer updateStudentWithFirstName(Long id, String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.updateFirstName(id, firstName);
	}

	public Integer deleteByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.deleteByFirstName(firstName);
	}

	public List<Student> getByCity(String city) {
		// TODO Auto-generated method stub
//		return studentRepository.findByAddressCity(city);
		return studentRepository.getByAddressCity(city);
	}
}
