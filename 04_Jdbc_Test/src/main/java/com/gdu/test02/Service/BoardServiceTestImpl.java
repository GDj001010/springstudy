package com.gdu.test02.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.test02.domain.BoardTestDTO;
import com.gdu.test02.repository.BoardTestDAO;


@Service
public class BoardServiceTestImpl implements BoardServiceTest {

	@Autowired
	private BoardTestDAO dao;
	
	@Override
	public List<BoardTestDTO> getBoardListTest() {
		dao.selectBoardList();
		return null;
	}

}
