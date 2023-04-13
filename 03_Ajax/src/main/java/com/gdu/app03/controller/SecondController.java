package com.gdu.app03.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app03.domain.BmiVO;
import com.gdu.app03.service.ISecondService;

import lombok.AllArgsConstructor;


@Controller
public class SecondController {

	private ISecondService secondService;
	
	// @AllArgsConstructor
	@Autowired	// 생성자에서 @Autowired는 생략 가능
	public SecondController(ISecondService secondService) {
		super();
		this.secondService = secondService;
	}
	
	
	@ResponseBody
	@GetMapping(value="/second/bmi1", produces=MediaType.APPLICATION_JSON_VALUE) // MediaType.APPLICATION_JSON_VALUE == "application/json" 이다.
	public BmiVO bmi1(HttpServletRequest request, HttpServletResponse response) {
		
		return secondService.execute1(request, response);
	}
	
	@ResponseBody
	@GetMapping(value="/second/bmi2", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> bmi2(BmiVO bmiVO){
		
		return secondService.execute2(bmiVO);
	}



	
}
