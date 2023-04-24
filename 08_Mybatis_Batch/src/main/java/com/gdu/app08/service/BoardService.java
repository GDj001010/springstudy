package com.gdu.app08.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app08.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();
	
	public BoardDTO getBoardByNo(HttpServletRequest request);
	
	public void addBoard(HttpServletRequest request, HttpServletResponse response);	// request로 받은 값들을 필요한 로직을 직접 짠 뒤 DAO로 보내준다.
	
	public void modifyBoard(HttpServletRequest request, HttpServletResponse response);
	
	public void removeBoard(HttpServletRequest request, HttpServletResponse response);
	
	public void removeBoardList(HttpServletRequest request, HttpServletResponse response);
	
	public void getBoardCount();
}
