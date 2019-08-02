package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dtos.Student;
import com.example.demo.exception.BussinessException;
import com.example.demo.exception.ValidationException;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/hello")
	public ModelAndView sayHello() {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		return model;
	}

	@GetMapping("/Details/{id}")
	public ModelAndView sayDetails(@PathVariable("id") Integer id) {
		if (id == 1) {
			throw new BussinessException("id 1 is not allowed");
		} else if (id == 2) {
			throw new ValidationException("id 2 is invalid please provide valid id");
		} else {
			ModelAndView model = new ModelAndView();
			model.setViewName("hello");
			return model;
		}
	}

	@RequestMapping(value = "/details/{id}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public @ResponseBody Student contentNegotiationTest(@PathVariable("id") Integer id) {

		Student model = new Student();
		model.setFirstName("Ashwini");
		model.setAddress("pune");
		model.setStuId(id);
		return model;
	}

	@ExceptionHandler(BussinessException.class)
	public ModelAndView handleBussiExe(Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("exception", ex);
		model.setViewName("error");
		return model;
	}

	@ExceptionHandler(ValidationException.class)
	public ModelAndView handleValidExe(Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("exception", ex);
		model.setViewName("error");
		return model;
	}
}