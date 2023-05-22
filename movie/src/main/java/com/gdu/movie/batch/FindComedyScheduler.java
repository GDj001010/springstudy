package com.gdu.movie.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.gdu.movie.service.MovieService;

public class FindComedyScheduler {
  
  @Autowired
  private MovieService movieService;
  
  @Scheduled(cron="0 0/1 * * * ?")
  public void execute() {
    
    movieService.file();
    
  }
  
}
