package com.gdu.app02.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {

	/*
		@RequestMapping을 대체하는 새로운 애너테이션 (Spring4 이후)
		1. @GetMapping		: GET 방식일 때 사용
		2. @PostMapping		: POST 방식일 때 사용
		3. @PutMapping		: PUT 방식일 때 사용 - 수정할 때 사용하는 레스터 방식
		4. @DeleteMapping	: DELETE 방식일 때 사용 - 삭제할 때 사용하는 레스터 방식
	*/
	
	/*
		요청 파라미터의 UTF-8 인코딩 처리
		
		메소드마다 request.setCharacterEncoding("UTF-8")을 작성하는 것은 매우 비효울적이므로,
		모든 요청(contextPath를 가진 모든 요청)마다 동작하도록 filter를 사용한다.
		web.xml 파일에서 CharacterEncodingFilter를 통해서 모든 요청마다 자동으로 UTF-8로 인코딩된다.
		참소할 파일 : web.xml
	*/
	
	// 1. HttpServletRequest로 요청 파라미터 처리하기
	// 받는 요청 request로 받고 주는 응답 model로 처리한다.
	@GetMapping("/detail.do")
	public String detail(HttpServletRequest request, Model model) {
		
		// name의 전달이 없으면 "홍길동"이 사용된다.
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("name"));
		String name = opt1.orElse("홍길동");
		
		// age 전달이 없으면 "0"이 사용된다.
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("age"));
		int age = Integer.parseInt(opt2.orElse("0"));
		
		/*
			Model model
			1. 스프링에서 사용하는 데이터(속성) 전달 객체이다.
			2. Model-2(Jsp/Servlet)에서는 HttpServletRequest 객체를 사용해서 데이터를 전달하지만,
				스프링에서는 Model model 객체를 사용한다.
			3. forward할 데이터를 Model의 addAttribute() 메소드로 저장한다.
			model도 request와 같이 속성으로 전달한다.
		*/
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		// 기본 이동 방식은 forward이다.	기본으로 parameter 들이 넘어간다.
		return "mvc/detail";	// 실제 처리 경로  : /WEB-INF/views/mvc/detail.jsp 
							
		/*
			참고. redirect로 이동하기
			return "redirect:이동할경로";
		*/
	}
	
	
	/*
		2. @RequestParam으로 요청 파라미터 처리하기
			1) value(속성)			: 파라미터 이름
			2) required(속성)		: 요청 파라미터의 필수 여부(디폴트는 true) parameter가 필수이기 때문에 parameter가 전달이 안 될시 400번 오류가 뜬다.
			3) defaultValue(속성)	: 요청 파라미터가 없을 때(null일 때) 대신 사용할 값
	*/
	
	@GetMapping("/detail.me")
	public String detailMe(@RequestParam(value="name", required=false, defaultValue="홍길동") String name,	// 요청 파라미터 name이 없으면 "홍길동"을 사용한다.
						   @RequestParam(value="age", required=false, defaultValue="0") int age,			// 요청 파라미터 age가 없으면 "0"을 사용한다.
						   Model model) {
						// parameter 값이 없으면 String 경우 null값이 저장되지만 int age엔 타입이 int이기 때문에 null값이 들어갈 수가 없다.
						// (String name, int age, Model model)  - 알아서 name 파라미터를 찾아서 String에 넣는다
						// 하지만 null 값을 잡을 수 없기 때문에 사용하지말자
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "mvc/detail";
	}
	
	/*			
		다른 예시
		@GetMapping("/detail.me")				// @RequestParam을 생략할 수 있다.
		public String detailMe(String name,		// 요청 파라미터 name이 없으면 null값이 저장되지만,
						   	   int age,			// 요청 파라미터 age가 없으면 null값을 int로 변환하려고 하기 때문에 오류가 뜬다.
						       Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "mvc/detail";
	*/
	
	/*
		파라미터에 객체로 String, int 값을 한 번에 받아올 수도 있다.
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
