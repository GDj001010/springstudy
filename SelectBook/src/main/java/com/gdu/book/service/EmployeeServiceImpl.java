package com.gdu.book.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.book.domain.EmpDTO;
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
		
		HttpSession session = request.getSession();		// session엔 모든 값을 저장할 수 있어 Object로 저장된다.
		Optional<Object> opt2 = Optional.ofNullable(session.getAttribute("recordPerPage"));
		int recordPerPage = (int)(opt2.orElse(10));
		
		pageUtil.setPageUtil(page, totalRecord, recordPerPage);
		
		Optional<String> opt3 = Optional.ofNullable(request.getParameter("column"));
		String column = opt3.orElse("EMPLOYEE_ID");
		
		Optional<String> opt4 = Optional.ofNullable(request.getParameter("order"));
		String order = opt4.orElse("ASC");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		map.put("column", column);
		map.put("order", order);
		
		List<EmpDTO> list =  employeeListMapper.getEmployeeList(map);
		
		model.addAttribute("employeeList", list);
		model.addAttribute("pagination", pageUtil.getPagination(request.getContextPath() + "employees/list.do?column=" + column + "&order=" + order));
		switch(order) {
		case "ASC" : model.addAttribute("order", "DESC"); break;  // 현재 ASC 정렬이므로 다음 정렬은 DESC이라고 Jsp에 알려준다.
		case "DESC": model.addAttribute("order", "ASC"); break;
		}
	}

}
