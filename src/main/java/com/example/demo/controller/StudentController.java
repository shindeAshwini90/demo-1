package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.Student;
import com.example.demo.exception.BussinessException;
import com.example.demo.exception.ValidationException;

@RestController
@RequestMapping("/student")
public class StudentController {

	Map<Integer, Student> map = new HashMap<>();
	Student st = new Student();

	@GetMapping("/details/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {

		st.setStuId(101);
		st.setFirstName("Ashwini");
		st.setAddress("Pune");
		
		if (id == 1) {
			return st;
		} else {
			return null;
		}
	}

	/*
	 * @PostMapping("/create") public void createStudent(@RequestBody @Valid Student
	 * st, BindingResult rs) { if(rs.hasErrors()) { throw new
	 * ValidationException("fisrt name should not be null"); }else {
	 * System.out.println("no error present :"+ st); } }
	 */

	@PostMapping("/create")
	public void createStudent(@RequestBody @Valid Student st, BindingResult rs) {
		if (rs.hasErrors()) {
			throw new ValidationException(rs.getFieldError().getDefaultMessage());
		} else {
			System.out.println("no error present :" + st);
			map.put(1, st);
		}
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student st1) {
		
		if (map.get(1).getStuId() == st1.getStuId()) {
			st.setStuId(st1.getStuId());
			st.setFirstName(st1.getFirstName());
			st.setAddress(st1.getAddress());
			map.put(1, st);
			return map.get(1);
		} else {
			throw new BussinessException("student not found");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable("id") Integer id) {
	
		System.out.println(map.get(1));
		if (map.get(1).getStuId() == id) {
			return map.remove(1);
		} else {
			throw new BussinessException("student not found");
		}
}
}
