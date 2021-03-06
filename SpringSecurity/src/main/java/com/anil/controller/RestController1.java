package com.anil.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anil.exception.EmpErrorResponse;
import com.anil.exception.EmpNotFound;
import com.anil.model.Employee;

@RestController
public class RestController1{

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
		if(eid<0||eid>=emp.size())
		{
			throw new EmpNotFound("employee with id: "+eid+" not exist");
		}
		Employee obj  =emp.get(eid);
		return obj;
		
	}
	
	@GetMapping("/hr/emp")
	public List<Employee> emplists()
	{
		return emp;
		
	}
	
	@PostMapping("/hr/emps")
	public void empadd(@RequestBody  Employee obj)
	{
		System.out.println("***we get yr object");
		
		
	}
	@PutMapping("/hr/empp")
	public void empupdate(@RequestBody  Employee obj)
	{
		System.out.println("***we get yr object in put");
		
		
	}
	@DeleteMapping("hr/empd/{eid}")
	public void delete(@PathVariable int id)
	{
		System.out.println("we get id: "+id+"for delete");
		
	}
	@ExceptionHandler
	public ResponseEntity<EmpErrorResponse> handle(EmpNotFound exe)
	{
		EmpErrorResponse err = new EmpErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<EmpErrorResponse>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<EmpErrorResponse> handle(Exception exe)
	{
		EmpErrorResponse err = new EmpErrorResponse();
		err.setMessage(exe.getMessage());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<EmpErrorResponse>(err, HttpStatus.BAD_REQUEST);
		
	}
	
} 
