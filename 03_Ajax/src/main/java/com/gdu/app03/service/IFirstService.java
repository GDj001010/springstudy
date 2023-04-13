package com.gdu.app03.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app03.domain.Person;

public interface IFirstService {
	// 하나의 인터페이스의 여러개의 메소드를 배치해서 하나의 클래스에서 모든 해결
	public Person execute1(HttpServletRequest requset, HttpServletResponse response);
	public Map<String, Object> execute2(String name, int age);
	public Map<String, Object> execute3(Person person);
	
}
