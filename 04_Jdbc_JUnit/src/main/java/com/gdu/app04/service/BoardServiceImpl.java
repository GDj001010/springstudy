package com.gdu.app04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app04.domain.BoardDTO;
import com.gdu.app04.repository.BoardDAO;
/*
	@Component
	1. BoardServiceImpl 클래스 타입의 객체를 만들어서 Spring Container에 저장하시오
		단, @Component가 @Autowired를 통해서 인식되려면 Component-Scan이 등록되어 있어야 한다.
	2. <bean> 태그나 @Configureation + @Bean 애너테이션을 대체하는 방식이다.
	3. Layer(계층)별 전용 @Component가 만들어져 있다.
		1) 컨트롤러 		: @Controller
		2) 서비스			: @Service
		3) 레파지토리(영속) : @Repository
*/
/*
	Component-Scan 등록 방법
	방법1. <context:component-scan> 태그 사용법		  - servlet-context.xml에 이미 등록되어 있다.
	방법2. @ComponentScan 			애너테이션 사용법 - 구지 직접 등록하지 않아도 된다.
*/
@Service	// Configuration, Bean 애너테이션을 구지 사용 안 해도 된다. (한 클래스에 모든 메소드가 모여있는 경우)
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getBoardByNo(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
