package com.anil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class startController {
	@GetMapping("/")
	public String home()
	{
		
		return "Home";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
}
