package com.gdu.app06.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.gdu.app06.domain.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	// Connection, PreparedStatement, ResultSet을 사용하는 스프링 클래스
	private String sql;

	public List<BoardDTO> getBoardList(){
		sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATED_AT, MODIFIED_AT FROM BOARD ORDER BY BOARD_NO DESC";
		List<BoardDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));	// rs값을 행 단위로 읽어 가져오는 값 = BeanPropertyRowMapper
	
		return list;
	}
	
	public int insertBoard(final BoardDTO BOARD) {
		sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'))";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, BOARD.getTitle());
				ps.setString(2, BOARD.getContent());
				ps.setString(3, BOARD.getWriter());
				
			}
		});
		
		return result;
	}
	
	public BoardDTO detailBoard(final int BOARD_NO) {	// 매개변수의 변조를 막기 위해서 final 처리한다. (예전에 매개변수 해킹 시도가 있었다.)
		sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATED_AT, MODIFIED_AT FROM BOARD WHERE BOARD_NO = ?";
		BoardDTO board = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), BOARD_NO);
		
		return board;
	}
	
	public int deleteBoard(final int BOARD_NO) {
		sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, BOARD_NO);
				
			}
		});
		
		return result;
	}
	
	public int modifyBoard(final BoardDTO BOARD) {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, MODIFIED_AT = TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE BOARD_NO = ?";
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, BOARD.getTitle());
				ps.setString(2, BOARD.getContent());
				ps.setInt(3, BOARD.getBoard_no());
				
			}
		});
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
