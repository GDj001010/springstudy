package com.gdu.app03.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app03.domain.BmiVO;

public interface ISecondService {
	public BmiVO execute1(HttpServletRequest request, HttpServletResponse response);
	// request 어떤 사용자든 오류없이 다 받아낼 수 있다.
	// response 잘못된 값이 전달되었을 때 대응
	
	// 커맨드 객체
	public Map<String, Object> execute2(BmiVO bmivo);
}
