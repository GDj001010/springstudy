package com.gdu.app04.service;

import java.util.List;

import com.gdu.app04.domain.BoardDTO;

public interface BoardService {
	
	// 서비스 계층(layer)의 메소드명은 가급적 "사용자 친화적"으로 작성하자.
	// 목록 (가짜)
	public List<BoardDTO> getBoardList();
	
	// 상세
	public BoardDTO getBoardByNo(int board_no);
	
	// 삽입
	public int addBoard(BoardDTO board);
	
	// 수정
	public int modifyBoard(BoardDTO board);
	
	// 삭제
	public int removeBoard(int board_no);
}
