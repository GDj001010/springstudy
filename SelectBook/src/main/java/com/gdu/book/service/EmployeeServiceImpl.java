package com.gdu.book.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.book.mapper.EmployeeListMapper;
import com.gdu.book.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeListMapper employeeListMapper;
	private PageUtil pageUtil;
	
	@Override
	public void getEmployeeList(HttpServletRequest request, Model model) {
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt1.orElse("1"));
		
		int totalRecord = employeeListMapper.getTotalRecord();
		
		HttpSession session = request.getSession();
		Optional<Object> opt2 = Optional.ofNullable(session.getAttribute("recordPerPage"));
		int recordPerPage = (int)opt2.orElse("10");
		
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		
		
		
		
		
		model.addAttribute("employeeList", employeeListMapper.getEmployeeList(null));
		
	}

}
