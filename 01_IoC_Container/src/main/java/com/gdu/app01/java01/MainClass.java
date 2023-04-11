package com.gdu.app01.java01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
			@Configuration, @Bean 애너테이션으로 생성한 Bean을 가져오는 스프링 클래스
			AnnotationConfigApplicationContext
		*/
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class); 	// AppContext.java 파일에 있는 Bean을 가져와 주세용
		// @Configuration 파일이 많은 경우  둘 이상의 패키지가 필요할 땐 배열로 오기 때문에 {} 중괄호를 이용하여 , 후 다음 경로를 작성해준다.
		// AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.java01");	// com.gdu.app01.java01 패키지에 있는 모든 Bean을 주세용
	
		User u = ctx.getBean("user1", User.class);
		System.out.println(u.getId());
		System.out.println(u.getContact().getTel());
		System.out.println(u.getContact().getFax());
		
		User u1 = ctx.getBean("user2", User.class);
		System.out.println(u1.getId());
		System.out.println(u1.getContact().getTel());
		System.out.println(u1.getContact().getFax());
		
		User u2 = ctx.getBean("user3", User.class);
		System.out.println(u2.getId());
		System.out.println(u2.getContact().getTel());
		System.out.println(u2.getContact().getFax());
		
		ctx.close();
	}

}
