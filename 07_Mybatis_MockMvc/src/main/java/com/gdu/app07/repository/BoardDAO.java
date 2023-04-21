package com.gdu.app07.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app07.domain.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NS = "mybatis.mapper.board.";
	
	public List<BoardDTO> selectBoardList(){
		return sqlSessionTemplate.selectList(NS + "selectBoardList");	// mybatis.mapper.board.selectBoardList 를 호출한다.
																		// 불러오는 값이 ArrayList 이기 때문에 곧바로 return이 가능하다.
	}
	
	public BoardDTO selectBoardByNo(int boardNo) {
		return sqlSessionTemplate.selectOne(NS + "selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) {
		int result = 0;
		result = sqlSessionTemplate.insert(NS + "insertBoard", board);
		if(result == 1) {
			return result;
		}
		return 0;
	}
	
	public int updateBoard(BoardDTO board) {
		int result = 0;
		result = sqlSessionTemplate.update(NS + "updateBoard", board);
		if(result == 1) {
			return result;
		}
		return 0;
	}
	
	public int deleteBoard(int boardNo) {
		int result = 0;
		result = sqlSessionTemplate.delete(NS + "deleteBoard", boardNo);
		if(result == 1) {
			return result;
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
