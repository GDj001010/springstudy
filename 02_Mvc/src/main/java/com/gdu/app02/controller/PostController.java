package com.gdu.app02.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app02.domain.Person;

@Controller
public class PostController {
	
	/*
	 	Prameter 받아오는 3가지 방법
	 	
	@GetMapping("/post/detail.do")
	public String detailPost(HttpServletRequest request, Model model) {
		
	}
	@GetMapping("/post/detail.do")
	public String detailPost(@RequestParam("name") String name,
							 @RequestParam("age") int age) {
		
	}
	@GetMapping("/post/detail.do")
	public String detailPost(Person p) {
		
	}
	*/
	@GetMapping("/post/detail.do")
	public String detailPost(HttpServletRequest request, Model model) throws Exception {	// request엔 name, age 파라미터가 있다
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("/post/detail.do");
		System.out.println("name: " + name + ", age: " + age);
		
		// return "redirect:이동할 경로";
		return "redirect:/post/list.do?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age;	// redirect를 해줄 땐 : ~~.jsp 가 아니라 mapping 값을 적어줘야 된다.
																		// redirect에서의 매핑경로는 jsp가 아닌 mapping (예시 : /post/list.do)
																		// redirect 하겠다 mapping 이동 forward 하겠다 jsp 이동
																		// /post/list.do 매핑으로 이동한다, name, age 파라미터를 다시 붙인다.
	}
	
	@GetMapping("/post/list.do")
	public String list(HttpServletRequest request, Model model) {	// request엔 name, age 파라미터가 있다
	
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		// /WEB-INF/views/post/list.jsp로 forward
		return "post/list";
		
	}
	
	@GetMapping("/post/detail.me")
		public String detailMe(HttpServletRequest request,
							   RedirectAttributes redirectAttributes) {	// Redirect할 때 속성(Attribute)을 전달하는 스프링 인터페이스이다.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		// Redirect 경로까지 전달되는 속성 : Flash Attribute
		redirectAttributes.addFlashAttribute("name", name);		// addAttribute()가 아님을 주의하세요!
		redirectAttributes.addFlashAttribute("age", age);
		
		return "redirect:/post/list.me";
	}
	
	@GetMapping("/post/list.me")
	public String listMe() {	// 받아올 request, 보내줄 Model 둘 다 필요가 없다
		
		// redirectAttributes로 온 것은 parameter로 온 것이 아닌 Redirect 경로까지 자동으로 전달되므로 별도의 코드가 필요하지 않다. (예시 : String name = request.getParameter("name")
		
		return "post/list";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
