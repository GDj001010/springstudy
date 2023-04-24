package com.gdu.app08.service;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app08.domain.BoardDTO;
import com.gdu.app08.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDTO> getBoardList() {
		
		return boardMapper.selectBoardList();
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
		return boardMapper.selectBoardByNo(boardNo);
	}

	@Override
	public void addBoard(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		BoardDTO board = new BoardDTO(0, title, content, writer, null, null);
		int addResult = boardMapper.insertBoard(board);
		
		try {	
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(addResult == 1) {
				out.println("alert('게시글이 등록되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			} else {
				out.println("alert('게시글 등록에 실패했습니다.')");
				out.println("history.back()");
			}
			out.println("</script>");
			out.flush();
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 

	@Override
	public void modifyBoard(HttpServletRequest request, HttpServletResponse response) {	// jsp 에서 post 방식으로 전달하기 때문에 값이 안 올 수가 없다.
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDTO board = new BoardDTO(boardNo, title, content, null, null, null);
		int modifyResult = boardMapper.updateBoard(board);
		try {	
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(modifyResult == 1) {
				out.println("alert('게시글이 등록되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/board/detail.do?boardNo=" + boardNo + "'");			} else {
				out.println("alert('게시글 등록에 실패했습니다.')");
				out.println("history.back()");
			}
			out.println("</script>");
			out.flush();
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeBoard(HttpServletRequest request, HttpServletResponse response) {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int deleteResult = boardMapper.deleteBoard(boardNo);
		try {	
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(deleteResult == 1) {
				out.println("alert('게시글이 등록되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			} else {
				out.println("alert('게시글 등록에 실패했습니다.')");
				out.println("history.back()");
			}
			out.println("</script>");
			out.flush();
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeBoardList(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 boardNoList
		String[] boardNoList = request.getParameterValues("boardNoList");
		
		int removeResult = boardMapper.deleteBoardList(Arrays.asList(boardNoList));	// Arrays.asList(boardNoList) : String[] boardNoList를 ArrayList로 바꾸는 코드
		
		
		try {	
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(removeResult == boardNoList.length) {
				out.println("alert('선택된 모든 게시글이 삭제되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			} else {
				out.println("alert('선택된 게시글이 삭제되지 않았습니다.')");
				out.println("history.back()");
			}
			out.println("</script>");
			out.flush();
			out.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void getBoardCount() {
		
		int boardCount = boardMapper.selectBoardCount();
		String msg = "[" + LocalDateTime.now().toString() + "] 게시글 갯수는 " + boardCount + "개입니다.";
		System.out.println(msg);
		
	}
	

}
