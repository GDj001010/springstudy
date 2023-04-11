package com.gdu.app01.java02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	// 임의의 학생 만들고, main 클래스에서 확인하기
	@Bean
	public Student student() {	// <bean id="student" class="Student">
		
		// 0~100 난수 5개
		List<Integer> scores = new ArrayList<Integer>();
		for(int i = 0; i < 5; i++) {					// 5번 반복
			scores.add((int)(Math.random() * 100) +1);	// 1부터 100개의 난수가 발생된다.
		}
		
		// 상 3개
		Set<String> awards = new HashSet<String>();
		awards.add("개근상");
		awards.add("장려상");
		awards.add("참가상");
		
		// address, tel
		Map<String, String> contact = new HashMap<String, String>();
		contact.put("adress", "seoul");
		contact.put("tel", "02-1234-5678");
		
		// Bean 생성 및 반환
		Student stu = new Student();
		stu.setScores(scores);
		stu.setAwards(awards);
		stu.setContact(contact);
		
		return stu;
	}
	
	
	
}
