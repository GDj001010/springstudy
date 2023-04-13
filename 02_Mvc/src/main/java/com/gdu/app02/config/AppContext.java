package com.gdu.app02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app02.domain.Bbs;

@Configuration
public class AppContext {

	// 1번째 Bean은 root-context.xml에 있다.
	
	@Bean
	public Bbs bbs2() {
		return new Bbs(2, "살려주세요", "2023-04-13");
	}
}
