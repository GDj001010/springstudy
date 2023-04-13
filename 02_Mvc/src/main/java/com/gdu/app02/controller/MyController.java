package com.gdu.app02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdu.app02.domain.Person;

/*
	@Controller
	안녕. 난 컨트롤러야. 
	@Component를 포함하고 있어서 자동으로 Spring Container에 Bean으로 등록된다.
	나는 스프링에 의해서 사용되고 있다.
*/
@Controller
public class MyController {
	
	// 메소드 : 요청, 응답을 처리하는 단위 하나의 요청과 응답은 하나의 메소드가 담당한다.
	
	/*
		메소드 작성 방법
		1. 반환타입 : String이란 (응답할 Jsp의 이름을 작성한다.)
		2. 메소드명 : 아무 일도 안 합니다. 아무 의미 없다.
		3. 매개변수 : 정해진 것이 없다, 요청과 응답에 따라 다르다.  (요청이 필요한 경우 HttpServletRequest, 응답이 필요한 경우 HttpServletResponse 등등)
	*/
	
	/*
		@RequestMapping
		1. value 	: URL Mapping을 작성한다. 		(동작할 주소를 작성한다.)
		2. method	: Request Method 를 작성한다. 	(GET, POST, PUT, DELETE 등)
		CRUD = 상황에 맞게 사용
	*/
	
	/*
		@RequestMapping(value="/", method=RequestMapping.GET)
		URL Mapping이 "/"이면 context path 경로를 의미한다. (http://localhost:9090/app02)
	*/
	// 언제 실행을 할지 정해주는 것 (@RequestMapping)
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";		// ViewResolver에 의해서 해석된다. (servlet-context.xml을 참고하자)
							// /Web-INF/views/index.jsp < (ViewResolver 에 의해서 작성된다.)
	}
	
	/*
		@RequestMapping 작성 예시
		@RequestMapping(value="/list.do", method=RequestMethod.GET)		: 정식 버전
		@RequestMapping(value="list.do", method=RequestMethod.GET)		: value는 슬래시(/)로 시작하지 않아도 된다. (핸들러 매핑이 니가 이거지 ? 알아서 찾아주기 때문이다.)
		@RequestMapping(value="/list.do")								: GET 방식의 method는 생략할 수 있다.
		@RequestMapping("/list.do")										: value 속성만 작성하는 경우에는 값만 작성하면 된다.
	*/
	@RequestMapping("/list.do")
	public String list() {
		return "board/list";	// ViewResolver에 의해서 실제 처리되는 경로는 : /WEB-INF/views/board/list.jsp
		/*
		 	만약 return에 슬래시(/)를 붙였을 경우
			return "/board/list";	슬래시(/)로 시작한 Jsp 경로
			실제 처리되는 경로 : 	/WEB-INF/views//board/list.jsp
			하지만, 실제로는 		/WEB-INF/views/board/list.jsp (원래 주소) 경로로 처리된다.
		*/
	}
	
	/*
		3. 커맨드 객체를 이용한 요청 파라미터 처리
			1) 파라미터를 필드로 가진 객체를 커맨드 객체라고 한다.
			2) setter가 사용된다.
			3) 커맨드 객체는 자동으로 Model에 저장된다.
	*/
	@GetMapping("/detail.gdu")
	public String detailGdu(Person p) {	// name과 age를 필드로 가진 Person p 커맨드 객체이다.
										// Model에 저장될 때 객체 이름인 p를 사용하지 않고,
										// 객체 타입인 Person을 사용한다. 객체 타입인 Person을 변수화 하여 person으로 부른다.
										// Model에 저장되는 속성명은 객체 타입 Person을 person으로 수정되서 person으로 사용할 수 있다.
		return "mvc/detail";
	}
	
	/*
	 	다른 예시
		@GetMapping("/detail.gdu")
		public String detailGdu(@ModelAttribute(value="p") Person person) {	 Model Attribute를 설정할 때 p라는 이름으로 설정해달라,
		return "mvc/detail";												 이렇게 해주면 detail.jsp 에선 person이라는 이름으로 저장되지 않고 p라는 이름으로 저장된다.
																			 ${p.name}, ${p.age} 와 같은 형식으로 호출할 수 있다.
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
