package com.example.springBootDemo.service;

import com.example.springBootDemo.dto.UserDto;
import com.example.springBootDemo.entity.User;
import com.example.springBootDemo.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IUserService extends IService<User> {
  Result<UserDto> login(String username, String password);

  Result<List<UserDto>> getUserList();

  Result<Object> register(String username, String email, String password);
}
