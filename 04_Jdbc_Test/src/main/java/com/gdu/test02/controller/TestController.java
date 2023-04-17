package com.gdu.test02.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.test02.Service.BoardServiceTest;

@RequestMapping("/board")
@Controller
public class TestController {

	@Autowired
	private BoardServiceTest boardService;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		System.out.println(boardService.getBoardListTest().size());
		return "board/list";
	}
	
}
