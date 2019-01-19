package com.anil.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.anil.model.Employee;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	List<Employee> emp = new ArrayList<Employee>();
	@PostConstruct
	public void storedata()
	{
		emp.add(new Employee(1, "anil", "java"));
		emp.add(new Employee(2, "suni", "python"));
		emp.add(new Employee(3, "sajid", "java"));
		emp.add(new Employee(4, "nakul", "java"));
		emp.add(new Employee(5, "ankue", "php"));
			
	}
	
	
	@GetMapping("/hr/emp/{eid}")
	public Employee emplist(@PathVariable int eid)
	{
		eid--;
		Employee obj  =emp.get(eid);
		return obj;
		
	}
}
