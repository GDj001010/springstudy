package com.gdu.book.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.book.service.EmployeeService;

@RequestMapping("/book")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list.do")
	public String list(HttpServletRequest request, Model model) {
		employeeService.getEmployeeList(request, model);
		return "book/list";
	}
	
}
