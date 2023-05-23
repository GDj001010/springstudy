package com.gdu.app13.domain;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodDTO {

  private int memberNo;
  private int blogNo;
  private Date markedAt;
  
}
