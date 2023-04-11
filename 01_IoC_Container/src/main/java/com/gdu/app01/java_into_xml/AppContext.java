package com.gdu.app01.java_into_xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Publisher pub() {
		Publisher pub = new Publisher();
		pub.setName("한국출판사");
		pub.setTel("010-4488-7784");
		return pub;
	}
	
	@Bean
	public Book book() {
		Book book = new Book();
		book.setTitle("어린왕자");
		book.setPublisher(pub());
		return book;
	}
	
}
