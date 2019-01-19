package com.anil.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.anil.model.Employee;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/hr/emp")
	public List<Employee> emplist()
	{
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(1, "anil", "java"));
		emp.add(new Employee(2, "suni", "python"));
		emp.add(new Employee(3, "sajid", "java"));
		emp.add(new Employee(4, "nakul", "java"));
		emp.add(new Employee(5, "ankue", "php"));
		return emp;
		
	}
}
