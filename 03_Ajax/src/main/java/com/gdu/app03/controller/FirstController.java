package com.gdu.app03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app03.domain.Person;
import com.gdu.app03.service.FirstServiceImpl;

@Controller
public class FirstController {
	
						
	@ResponseBody		// 값을 응답 본문(요청한 곳)에 데이터를 응답해주세요, 메소드의 반환 값을 Jsp이름으로 해석하지 않도록 해준다. 그냥 응답하는 값(데이터)이다.
	@GetMapping(value="/first/ajax1", produces="application/json")	// value 속성만 입력할 땐 value를 생략해도 되지만 ajax 응답 타입이 json이기 때문에 produces 속성을 입력해준다, produces 속성엔 응답 데이터의 MIME TYPE을 작성해준다
	public Person ajax1(HttpServletRequest request) {				// "Jackson" 라이브러리가 반환값 Person 객체를 자동으로 JSON 데이터로 변환한다.
		return (new FirstServiceImpl()).execute1(request);			// "redirect:" 가 없기 떄문에 forward로 되면서 (new FirstServiceImpl()).execute1(request); 코드가 jsp로 인식한다.
																	// 	ajax은 페이지를 안 바꾸고 동일한 페이지에서 요청하고 값을 받아온다.
	}
	
}
