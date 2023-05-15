package com.gdu.app12.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private int userNo;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String emaol;
	private String mobile;
	private String birthyear;
	private String birthdate;
	private String postcode;
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private int agreeCode;
	private String joineAt;
	private String pwModifiedAt;
	private String autologinId;
	private String autologinExpiredAt;
	
}
