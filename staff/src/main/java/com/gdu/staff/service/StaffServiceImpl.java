package com.gdu.staff.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;
	
	@Override
	public ResponseEntity<List<StaffDTO>> getStaffList() {
		List<StaffDTO> staffList = staffMapper.getStaffList();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<StaffDTO>>(staffList, header, HttpStatus.OK) ;
	}
	
	
	
	
	@Override
	public ResponseEntity<String> addStaff(StaffDTO staffDTO) {
		try {
			staffMapper.addStaff(staffDTO);
			return new ResponseEntity<String>("사원 등록이 성공했습니다.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("사원 등록이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@Override
	public ResponseEntity<StaffDTO> getQuery(String query) {
		try {
			StaffDTO staffDTO = staffMapper.getQuery(query);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<StaffDTO>(staffDTO, header, HttpStatus.OK) ;
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
