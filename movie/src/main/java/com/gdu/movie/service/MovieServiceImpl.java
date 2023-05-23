package com.gdu.movie.service;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.domain.QueryDTO;
import com.gdu.movie.mapper.MovieMapper;
import com.gdu.movie.util.SecurityUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

  private MovieMapper movieMapper;
  private SecurityUtil securityUtil;
  
  @Override
  public Map<String, Object> getAllMovies() {
    
    List<MovieDTO> list = movieMapper.getAllMovies();
    
    int status = 0;
    String message = null;
    if(list.isEmpty()) {
      status = 500;
      message = "목록이 없습니다.";
    } else {
      status = 200;
      message = "전체" + list.size() + "개의 목록을 가져왔습니다.";
    }
    
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("list", list);
    map.put("message", message);
    map.put("status", status);
    
    return map;
  }

  @Override
  public Map<String, Object> getMoviesByQuery(QueryDTO queryDTO) {
    
    queryDTO.setSearchText( securityUtil.preventXSS(queryDTO.getSearchText()) );
    
    List<MovieDTO> list = movieMapper.getMoviesByQuery(queryDTO);
    int status = 0;
    String message = null;
    
    if(list.isEmpty()) {
      status = 500;
      message = queryDTO.getSearchText() + "검색 결과가 없습니다.";
    } else {
      status = 200;
      message = list.size() + "개의 검색 결과가 있습니다.";
    }
    
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("list", list);
    map.put("message", message);
    map.put("status", status);
    
    return map;
  }

  @Override
  public void file() {
    try {
    // FileWriter fileWriter = null;
    File file = null;
    
    String column = "TITLE";
    String searchText = "코미디";
    
    QueryDTO queryDTO = new QueryDTO(column, searchText);
    
    List<MovieDTO> list = movieMapper.getMoviesByQuery(queryDTO);
    if(list.isEmpty()) {
      // fileWriter = new FileWriter("error.txt");
      // fileWriter.write("코미디 검색 결과가 없습니다.");
      // fileWriter.close();
      file = new File("error.txt");
      if(file.exists() == false) {
        file.createNewFile();
      }
    } else {
      // fileWriter = new FileWriter("코미디.txt");
      file = new File("코미디.txt");
      if(file.exists() == false) {
        file.createNewFile();
      }
      StringBuilder sb = new StringBuilder();
      
      for(int i = 0; i < list.size(); i++) {
        sb.append("제목: " + list.get(i).getTitle());
        sb.append("\n");
        sb.append("장르: " + list.get(i).getGenre());
        sb.append("\n");
        sb.append("개요: " + list.get(i).getDescription());
        
      }
      
        
       // fileWriter.write(sb.toString());
        
       // fileWriter.close();
    }
    
   
    } catch(Exception e) {
      e.printStackTrace();
    }
    
  }
  
  
  
  
}
