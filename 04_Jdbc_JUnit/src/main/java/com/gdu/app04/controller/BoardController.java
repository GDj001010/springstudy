package com.gdu.app04.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdu.app04.service.BoardService;

@RequestMapping("/board")	// 모든 mapping에 /board가 prefix로 추가됩니다. (앞에 추가가 된다.)
@Controller
public class BoardController {
	
	@Autowired 
	private BoardService boardService;	// Spring Container에 저장된 Service 객체를 사용할 곳은 Controller이다.

	@GetMapping("/list.do")
	public String list(Model model) {  // Model : jsp로 전달(forward)할 데이터(속성, attribute)를 저장한다.
		System.out.println(boardService.getBoardList());
		return "board/list";
	}
	
}
