package com.gdu.app04.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.BoardDTO;
import com.gdu.app04.service.BoardService;

@RequestMapping("/board")	// 모든 mapping에 /board가 prefix로 추가됩니다. (앞에 추가가 된다.)
@Controller
public class BoardController {
	
	@Autowired 
	private BoardService boardService;	// Spring Container에 저장된 Service 객체를 사용할 곳은 Controller이다.

	@GetMapping("/list.do")
	public String list(Model model) {  // Model : jsp로 전달(forward)할 데이터(속성, attribute)를 저장한다.
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}
	
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	
	@PostMapping("/add.do")
	public String add(BoardDTO board, Model model) {	// 파라미터값 받는 방법 3가지  1. HttpServletRequest (통일), 2. @RequestParam, 3. BoardDTO board
		boardService.addBoard(board);		// addBoard() 메소드의 호출 결과인 int 값(0 또는 1)은 사용하지 않았다.
		
		return "redirect:/board/list.do";	// 목록보기로 redirect 하겠다 (redirect 경로는 항상 mapping으로 작성한다.)
	}
	
	
	@GetMapping("/detail.do")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no, Model model) {	// 목록, 상세보기는 내용전달을 위한 model이 필요하다.
		model.addAttribute("b", boardService.getBoardByNo(board_no));
		return "board/detail";
	}
	
	@GetMapping("/remove.do")
	public String remove(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no, Model model) {
		boardService.removeBoard(board_no);
		
		return "redirect:/board/list.do";
	}
	
	
	@PostMapping("/modify.do")
	public String modify (BoardDTO board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail.do?board_no=" + board.getBoard_no();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
