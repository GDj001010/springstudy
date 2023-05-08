package com.gdu.app11.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app11.mapper.UploadMapper;
import com.gdu.app11.util.MyFileUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UploadServiceImpl implements UploadService {
	
	// field
	private UploadMapper uploadMapper;
	private MyFileUtil myFileUtil;
	
	@Override
	public int addUpload(MultipartHttpServletRequest multipartRequest) {

		// Upload 테이블에 UploadDTO 넣기
		
		
		
		
		// Attach 테이블에 AttachDTO 넣기
		
		// MultipartFile를 이용하여 파일 업로드
		List<MultipartFile> files = multipartRequest.getFiles("files");	// 여기서 files는 파라미터 name값이다. <input type="file" name="files">
		
		// 첨부된 파일이 있는지 체크
		if(files != null && files.isEmpty() == false) {
		
			// 첨부된 파일 목록 순회
			for(MultipartFile multipartFile : files) {
				
				// 예외 처리
				try {
					
					// 첨부 파일의 저장 경로
					String path = myFileUtil.getPath();
					
					// 첨부 파일의 저장 경로가 없으면 만들기
					File dir = new File(path);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					
					// 첨부 파일의 원래 이름
					String originName = multipartFile.getOriginalFilename();
					originName = originName.substring(originName.lastIndexOf("\\") + 1);	// IE는 전체 경로가 오기 때문에 마지막 역슬래시 뒤에 있는 파일명만 사용한다.
					
					// 첨부 파일의 저장 이름
					String filesystemName = myFileUtil.getFilesystemName(originName);
					
					// 첨부 파일의 File 객체 (HDD에 저장할 첨부 파일)
					File file = new File(dir, filesystemName);
					
					// 첨부 파일을 HDD에 저장
					multipartFile.transferTo(file);		// 실제로 서버에 저장된다.
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		return 0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
