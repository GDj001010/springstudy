package com.gdu.app11.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {

	public int addUpload(MultipartHttpServletRequest multipartRequest);	// 첨부에선 HttpServletRequest가 아닌 MultipartHttpServletRequest를 사용한다.
	
}
