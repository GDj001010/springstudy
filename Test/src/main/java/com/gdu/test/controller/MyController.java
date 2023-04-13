package com.gdu.test.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list.do")
	public String list() {
		return "board/list";
	}
	
	@GetMapping("/detail.do")
	public String detail(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("name"));
		String name = opt.orElse("홍길동");
		
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("age"));
		int age = Integer.parseInt(opt1.orElse("0"));
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "board/detail";
	}
	
	
	

}
