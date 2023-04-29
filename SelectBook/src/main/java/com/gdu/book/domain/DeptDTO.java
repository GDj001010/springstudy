package com.gdu.book.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {

	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
}
