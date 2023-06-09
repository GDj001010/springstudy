package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.repository.BoardDAO;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> boardList() {
		
		return boardDAO.getBoardList();
	}
	
	@Override
	public int addBoard(BoardDTO board) {
		
		return boardDAO.insertBoard(board);
	}
	
	@Override
	public BoardDTO detailBoard(int board_no) {
		
		return boardDAO.detailBoard(board_no);
	}
	
	@Override
	public int deleteBoard(int board_no) {
		
		return boardDAO.deleteBoard(board_no);
	}
	
	@Override
	public int updateBoard(BoardDTO board) {
		
		return boardDAO.modifyBoard(board);
	}
	
	// AOP를 활용한 트랜잭션 처리 테스트
	@Override
	public void testTx() {
		
		// 2개 이상의 삽입, 수정, 삭제가 하나의 서비스에서 진행되는 경우에 트랜잭션 처리가 필요하다.
		
		// 성공하는 작업
		boardDAO.insertBoard(new BoardDTO(0, "트랜잭션제목", "트랜잭션내용", "트랜잭션작성자", null, null));	// RollBack
		
		// 실패하는 작업
		boardDAO.insertBoard(new BoardDTO());	// TITLE 칼럼은 not null이기 때문에 Exception 발생
		
		// 트랜잭션 처리가 된다면 모든 insert가 실패해야 한다.
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
