package com.example.springBootDemo.dto;

import lombok.Data;

@Data
public class UserDto {
  private Integer userId;
  private String username;
  private String email;
  private String token;
  private String createTime;
  private String updateTime;
}
