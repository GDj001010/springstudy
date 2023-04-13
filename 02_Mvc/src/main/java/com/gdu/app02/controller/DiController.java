package com.gdu.app02.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app02.domain.Bbs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class DiController {
	
	/*
		Spring Container에 저장되어 있는 Bean을 가져올 수 있는 Annotation(애너테이션)
		
		1. @Inject
			1) Bean의 타입(class)이 일치하는 Bean을 가져온다.
			2) 만약 동일 타입의 Bean이 2개 이상이면 오류가 발생한다.
			3) 동일 타입의 Bean을 구별하기 위해서 @Qualifier 애너테이션을 사용할 수 있다.
			
		2. @Resource
			1) Bean의 이름(id)이 일치하는 Bean을 가져온다.
			2) 동일한 이름의 Bean이 없으면 오류가 발생한다.
			
		3. @Autowired - 자동으로 묶어준다
			1) Bean의 타입(class)이 일치하는 Bean을 가져온다. (인젝트 기반이다)
			2) 만약 동일 타입의 Bean이 2개 이상이면 Bean의 이름(id)이 일치하는 Bean을 가져온다. (class체크 이후 id 체크)
			3) 이걸 쓴다.
		
	*/
	
	/*
		@Autowired 사용 방법 3가지
		
		1. 필드에 @Autowired 선언하기
			1) 필드에 자동으로 Bean을 주입한다.
			2) 각 필드마다 @Autowired를 선언한다.
			3) 필드가 10개이면 @Autowired를 10번 선언해야 한다. (필드가 많은 경우 사용하지 않는다.)
			
		2. 생성자에 @Autowired 선언하기
			1) 생성자의 매개변수(괄호 안에 있는 변수)에 있는 객체들에 자동으로 Bean을 주입한다.
			2) 생성자에는 @Autowired 선언을 생략할 수 있다. (일반적으로 생략한다.)
			
		3. 메소드에 @Autowired 선언하기
			1) 메소드의 매개변수(괄호 안에 있는 변수)에 있는 객체들에 자동으로 Bean을 주입한다.
			2) 메소드에는 @Autuwired 선언을 생략할 수 없다.
	*/
	
	/*
		Spring Container 에 p라는 객체(bean) 저장
		@Inject
		Person p;  < p 객체 불러옴
	 */
	
	
	
	// <필드 버전>
	// @Autowired 선언시 Spring Container에서 같은 타입이 2가지 이상 있다면 id를 비교하여 Bean 객체를 주입한다.
	private Bbs bbs1;
	private Bbs bbs2;
	
	/*
	<생성자 버전>
	애너테이션 @AllArgsConstructor 을 클래스에 선언시 Autowired 선언이 기본값이기 때문에 선언이 필요없다.
	public DiController(Bbs bbs1, Bbs bbs2) {	// Spring Container 에서 알아서 찾아 매개변수에 Bean을 주입한다.
		super();
		this.bbs1 = bbs1;
		this.bbs2 = bbs2;
	}
	*/
	
	/*
	<메소드 버전>
	@Autowired
	public void method(Bbs bbs1, Bbs bbs2) {	// @Autowired 선언시 메소드에 매개변수를 대상으로 Spring Container에서 Bean 객체를 가져와 자동으로 주입된다.
		this.bbs1 = bbs1;
		this.bbs2 = bbs2;
	}
	*/
	
	/*
		<bean id="bbs1" class="Bbs">
		
		메소드의 타입 : class 메소드명 : id
		@Bean public Bbs bbs1() {}
	*/
	
	// a 태그로 보내는 방식이기 때문에 get 방식, contextPath값 뒤에 mapping 값들 작성
	@GetMapping("/bbs/detail.do")
	public String detail(Model model) {
		
		model.addAttribute("bbs1", bbs1);
		model.addAttribute("bbs2", bbs2);
		
		return "bbs/detail";	// 실제 처리 경로 : /WEB-INF/views/bbs/detail.jsp  < View Resolver 가 처리해주는 경로 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
