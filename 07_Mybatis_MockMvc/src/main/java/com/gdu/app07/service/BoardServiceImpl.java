package com.gdu.app07.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() {
		
		return boardDAO.selectBoardList();
	}

	@Override
	public BoardDTO getBoardByNo(HttpServletRequest request) {
		// 파라미터 boardNo가 없으면 (null, "") 0을 사용한다.
		/*
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));	// optional은 null 처리만 가능하고 "" 문자열은 처리 못 한다.
		int boardNo = Integer.parseInt(opt.orElse("0"));								// jsp에서 get 방식이 때문에 null, "" 문자열 처리를 해줘야 된다.
		*/
		// 정수가 아닐 때 잡고 싶으면 jsp에서 잡아라, JavaScrip에서 isNaN() 함수 사용
		String strBoardNo = request.getParameter("boardNo");
		int boardNo = 0;
		if(strBoardNo.isEmpty() == false && strBoardNo != null) {
			boardNo = Integer.parseInt(strBoardNo);
		}
		return boardDAO.selectBoardByNo(boardNo);
	}

	@Override
	public int addBoard(HttpServletRequest request) {
		try {		// 입력에 실패한다면 0을 준다.
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			BoardDTO board = new BoardDTO(0, title, content, writer, null, null);
			return boardDAO.insertBoard(board);
			
		} catch(Exception e) {
			return 0;
		}
	} 

	@Override
	public int modifyBoard(HttpServletRequest request) {	// jsp 에서 post 방식으로 전달하기 때문에 값이 안 올 수가 없다.
		try {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardDTO board = new BoardDTO(boardNo, title, content, null, null, null);
			return boardDAO.updateBoard(board);
		} catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int removeBoard(HttpServletRequest request) {
		try {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			return boardDAO.deleteBoard(boardNo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	// 트랜잭션 확인		트랜잭션이 필요하다면 내가 직접 명시해준다.
	@Transactional // 메소드가 실행할 때 트랜잭션이 적용된다, 삽입, 수정, 삭제를 두 개씩 사용할 때 해준다.
	@Override
	public void testTx() {
		boardDAO.insertBoard(new BoardDTO(0, "테스트", "테스트", "테스트", null, null));
		boardDAO.insertBoard(new BoardDTO());

		
	}

}
