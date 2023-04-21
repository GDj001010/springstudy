package com.gdu.app07.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gdu.app07.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();
	
	public BoardDTO getBoardByNo(HttpServletRequest request);
	
	public int addBoard(HttpServletRequest request);	// request로 받은 값들을 필요한 로직을 직접 짠 뒤 DAO로 보내준다.
	
	public int modifyBoard(HttpServletRequest request);
	
	public int removeBoard(HttpServletRequest request);
	
	public void testTx();
}
