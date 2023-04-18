package com.gdu.app05.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app05.domain.BoardDTO;
import com.gdu.app05.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	// BoardUnitTest 클래스를 실행할 때 org.slf4j.Logger를 동작시킨다
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		List<BoardDTO> list = boardService.getBoardList();
		LOGGER.debug(list.toString());
		model.addAttribute("boardList", list);
		
		return "board/list";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	
	@GetMapping("/detail.do")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no, Model model) {
		LOGGER.debug(board_no + "");	// 파라미터 확인
		BoardDTO b = boardService.getBoardByNo(board_no);
		LOGGER.debug(b.toString());
		model.addAttribute("b", boardService.getBoardByNo(board_no));
		return "board/detail";
	}
	
	@PostMapping("/add.do")
	public String write(BoardDTO board) {
		LOGGER.debug(board.toString());		// 파라미터
		LOGGER.debug(boardService.addBoard(board) + "");	// 실행 결과
		boardService.addBoard(board);
		return "redirect:/board/list.do";
	}
	
	@PostMapping("/modify.do")
	public String edit(BoardDTO board) {
		LOGGER.debug(board.toString());	// 파라미터 확인
		LOGGER.debug(boardService.modifyBoard(board) + "");	// 결과 확인
		boardService.modifyBoard(board);
		return "redirect:/board/detail.do?board_no" + board.getBoard_no();
	}
	
	@GetMapping("remove.do")
	public String remove(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no) {
		LOGGER.debug(board_no + "");	// 파라미터 확인
		LOGGER.debug(boardService.removeBoard(board_no) + "");
		boardService.removeBoard(board_no);
		return "redirect:/board/list.do";
	}
	
	
	
	
	
	
	
	
}
