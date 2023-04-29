package com.gdu.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@Controller
public class EmployeeController {

	@GetMapping("/list.do")
	public String list() {
		
		return "/book/list";
	}
	
}
