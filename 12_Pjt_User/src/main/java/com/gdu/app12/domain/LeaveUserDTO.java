package com.gdu.app12.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveUserDTO {
	private String id;
	private String joineAt;
	private String leavedAt;
	private String email;
	
}
