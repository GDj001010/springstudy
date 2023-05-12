package com.gdu.staff.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;


@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	
	
	@GetMapping("/list.json")
	public ResponseEntity<List<StaffDTO>> list(){
		return staffService.getStaffList();
	}
	
	
	
	@PostMapping(value="/add.do", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> add(StaffDTO staffDTO){
		return staffService.addStaff(staffDTO);
	}
	
	
	@GetMapping("/query.json")
	public ResponseEntity<StaffDTO> query(@RequestParam(value="query", defaultValue="0",required=false) String query){
		
		return staffService.getQuery(query);
	}
	
}
