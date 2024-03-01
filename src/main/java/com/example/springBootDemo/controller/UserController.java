package com.example.springBootDemo.controller;

import com.example.springBootDemo.dto.UserDto;
import com.example.springBootDemo.service.IUserService;
import com.example.springBootDemo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public Result<UserDto> loginUser(@RequestParam String username, @RequestParam String password) {
    return userService.login(username, password);
  }

  @GetMapping("/getUserList")
  public Result<List<UserDto>> getUserList() {
    return userService.getUserList();
  }

  @PostMapping("/register")
  public Result<Object> registerNewUser(@RequestBody Map<String, String> request) {
    String username = request.get("username");
    String email = request.get("email");
    String password = request.get("password");

    return userService.register(username, email, password);
  }
}
