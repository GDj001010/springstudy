package com.gdu.app01.java01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
	@Configuration
	안녕. 난 Configuration이라고 해.
	Spring Container에 Bean을 만들어 두는 Java 클래스야.
	Spring Bean Configuration File하고 같은 일을 하지.
*/
@Configuration
public class AppContext {

	// Bean을 만들고 싶으면 메소드를 만들면 된다. (Bean 하나 = 메소드 하나)
	
	/*
		안녕. 난 Bean을 만드는 메소드야.
		반환타입이 Bean의 타입(<bean> 태그의 class 속성)이고,
		메소드명이 Bean의 이름(<bean> 태그의 id 속성)이다.
	*/
	@Bean
	public Contact contact1() {		// <bean id="contact1" class="Contact">
		Contact c = new Contact();	// default constructor
		c.setTel("02-2222-8884");	// setter	<property name="tel" value="02-2222-8884" />
		c.setFax("02-4488-8795");	// setter	<property name="fax" value="02-4488-8795" />
		return c;					// 반환한 객체 c가 Spring Container에 저장됩니다.
	}
	
	@Bean
	public User user1() {			// <bean id="user1" class="User">
		User u = new User();		// default constructor
		u.setId("spider");			// setter <property name="id" value="spider" />
		u.setContact(contact1());	// setter <property name="contact" ref="contact1" />
		return u;					// 반환한 객체 u가 Spring Container에 저장됩니다.
	}
	
	// contact2, user2 빈을 constrictor를 이용해서 만들어 보세요. 그리고 MainClass에서 확인하세요.
	
	@Bean(name="contact2")		// name 속성이 추가되면 Bean의 id로 사용됩니다.
	public Contact www() {		// name 속성이 사용되었으므로 메소드명은 더 이상 Bean의 id가 아니다.
		return new Contact("02-333-3333", "02-333-3334");
	}
	
	@Bean(name="user2")			// name 속성이 추가되면 Bean의 id로 사용됩니다.
	public User aaa() {			// name 속성이 사용되었으므로 메소드명은 더 이상 Bean의 id가 아니다.
		return new User("admin", www());
	}
	
	
	// constructor 사용법
	@Bean
	public Contact contact3() {
		Contact c = new Contact("02-778-4484", "02-4448-2215");
		return c;
	}
	
	@Bean
	public User user3() {
		User u = new User("gojingamle", contact3());
		return u;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
