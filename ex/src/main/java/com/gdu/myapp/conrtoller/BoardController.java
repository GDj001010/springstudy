package com.gdu.myapp.conrtoller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers.AtomicIntegerSerializer;
import com.gdu.myapp.domain.BoardDTO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {
	

	@GetMapping({"/", "index.do"})	// http://localhost:9090/myapp 요청이 옴 = context path 경로
	// 반환타입 String : 이동할 jsp 이름을 반환한다. 반환된 이름은 servlet-context.xml의 ViewResolver에 의해서 rendering 된다. (prefix + 반환값 + suffix)
	public String index() {
		return "index";
	}
	/*
	// 반환타입이 없기 때문에 urlMapping이 jsp 이름인줄 안다. (404 에러가 나오면서 detail.jsp 를 찾는다.)
	// <a>, location.href
	@GetMapping("/detail.do")
	public void detail1(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		System.out.println(boardNo + ", " + title);
	}
	
	// <form>
	@PostMapping("/detail.do")
	public void postDetail(HttpServletRequest request) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		System.out.println(boardNo + ", " + title);
	}
	*/
	
	/*
	@GetMapping("/detail.do")	// required 파라미터는 필수가 아니다 
	public void getDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo,
						  @RequestParam(value="title", required=false, defaultValue="빈제목") String title) {
		System.out.println(boardNo + ", " + title);
	}
	
	@PostMapping("/detail.do")
	public void postDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo,
			  			   @RequestParam(value="title", required=false, defaultValue="빈제목") String title) {
		System.out.println(boardNo + ", " + title);
	}
	
	*/
	/*
	@GetMapping("/detail.do")
	public void getDetail(BoardDTO board) {		// board.setBoardNo()와 board.setTitle()이 여기서 사용된다.
		System.out.println(board);	// 객체를 출력하면 domain에 @Data 애너테이션으로 인해 toString이 자동적으로 동작한다.
		System.out.println(board.getBoardNo() + board.getTitle());
	}
	
	@PostMapping("/detail.do")
	public void postDetail(BoardDTO board) {
		System.out.println(board);	// 객체를 출력하면 domain에 @Data 애너테이션으로 인해 toString이 자동적으로 동작한다.
		System.out.println(board.getBoardNo() + board.getTitle());
	}
	*/
	
	
	// Model (request 기반)
	// 1. 주 목적 : jsp로 forward 할 데이터(attribute)를 저장하는 용도 
	// 2. 속성(attribute) 저장소 4개(pageContext, request, session, application) 중에서 request를 이용한다.
	// 3. 컨트롤러에서만 선언할 수 있다.
	/*
	@GetMapping("/detail.do")
	public String getDetail(HttpServletRequest request, Model model) {
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt1.orElse("0"));
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("title"));
		String title = opt2.orElse("빈제목");
		model.addAttribute("boardNo", boardNo);	// request.setAttribute("boardNo", boardNo);
		model.addAttribute("title", title);
		return "detail";
	}
	
	
	@PostMapping("/detail.do")
	public String postDetail(HttpServletRequest request, Model model) {
		Optional<String> opt2 = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt2.orElse("0"));
		Optional<String> opt1 = Optional.ofNullable(request.getParameter("title"));
		String title = opt1.orElse("빈제목");
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("title", title);
		return "detail";
	}	
	*/
	/*
	@GetMapping("/detail.do")	// required 파라미터는 필수가 아니다 
	public String getDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo,
						    @RequestParam(value="title", required=false, defaultValue="빈제목") String title
						  , Model model) {

		model.addAttribute("boardNo", boardNo);
		model.addAttribute("title", title);
		return "detail";
	}
	
	@PostMapping("/detail.do")
	public String postDetail(@RequestParam(value="boardNo", required=false, defaultValue="0") int boardNo,
			  			   @RequestParam(value="title", required=false, defaultValue="빈제목") String title
			  			   , Model model) {
		
		model.addAttribute("boardNo", boardNo);
		model.addAttribute("title", title);
		return "detail";
	}
	
	*/
	
	@GetMapping("/detail.do")
	public String getDetail(BoardDTO board) {		// 파라미터를 객체로 받으면 자동으로 Model에 저장이 된다.! 속성명은 : boardDTO (클래스 타입이 이름이 되며 앞글자가 소문자가 된다.)
													// 이미 model에 들어가 있다.
		
		return "detail";
	}
	
	@PostMapping("/detail.do")
	public String postDetail(@ModelAttribute("board") BoardDTO board) {	// Model에 저장하는 속성명을 "board"로 하겠다.		
		
		return "detail";
	}
	
	
	
	
	
	
	
	
	
	
}
