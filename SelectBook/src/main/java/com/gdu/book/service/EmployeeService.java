package com.gdu.book.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public interface EmployeeService {

	public void getEmployeeList(HttpServletRequest request, Model model);
	
}
