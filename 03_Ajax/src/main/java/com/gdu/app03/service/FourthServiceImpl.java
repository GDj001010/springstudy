package com.gdu.app03.service;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

public class FourthServiceImpl implements IFourthService {

	@Override
	public ResponseEntity<byte[]> display(String path, String filename) {
		
		// path와 filename을 이용해서 File 객체 만들기
		File file = new File(path, filename);
		
		try {
			
			// file 객체를 byte 배열로 복사하기
			byte[] b = FileCopyUtils.copyToByteArray(file);		// byte 값을 준다
			
			// byte 배열이 된 이미지 파일을 반환하기
			return new ResponseEntity<byte[]>(b, HttpStatus.OK);		// 진짜 반환
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;	// 가짜 반환 (문법 맞추기 용)
	}
}
