package com.gdu.app06.service;

import java.util.List;

import com.gdu.app06.domain.BoardDTO;

public interface BoardService {
	
	public List<BoardDTO> boardList();
	
	public int addBoard(BoardDTO board);
	
	public BoardDTO detailBoard(int board_no);
	
	public int deleteBoard(int board_no);
	
	public int updateBoard(BoardDTO board);
	
	public void testTx();
}
