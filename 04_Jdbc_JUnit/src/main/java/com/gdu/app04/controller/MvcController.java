package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

	@RequestMapping("/")	// 웰컴 파일 작업하기, (웰컴 파일 시작 파일)
	public String index() {
		return "index";
	}
	
}
