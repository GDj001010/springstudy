package com.gdu.book.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.book.domain.EmpDTO;

@Mapper
public interface EmployeeListMapper {
	
	public int getTotalRecord();
	public List<EmpDTO> getEmployeeList(Map<String, Object> map);
	
}
