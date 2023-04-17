package com.gdu.app04.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.app04.domain.BoardDTO;

				// Spring Container는 default값이 singleton이다. (하나만 만들어서 가져다 쓴다.)
@Repository		// Spring Container에 저장, DAO가 사용하는 @Componen이다, Spring Container에 Bean이 등록될 때 Singleton으로 등록되기 때문에 별도의 Singleton Pattern 코드를 작성할 필요가 없다.
public class BoardDAO {
	
	// jdbc 방식
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// private 메소드 -1 (BoardDAO 클래스 내부에서만 사용)
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDrivre");	// ojdbc8.jar 메모리 로드
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GDJ61", "1111");
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	// private 메소드 - 2 (BoardDAO 클래스 내부에서만 사용)
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// DAO 메소드 (BoardServiceImpl 클래스에서 사용하는 메소드)
	// DAO 메소드명
	// 방법1. BoardServiceImpl의 메소드와 이름을 맞춤
	// 방법2. DB 친화적으로 새 이름을 부여
	
	// 1. 목록
	public List<BoardDTO> selectBoardList(BoardDTO board){
		
		return null;
	}
	
	
	// 2. 상세
	
	
	
	// 3. 삽입
	
	
	
	// 4. 수정
	
	
	
	// 5. 삭제
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
