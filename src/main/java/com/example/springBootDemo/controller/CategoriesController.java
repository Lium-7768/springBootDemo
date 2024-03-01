package com.example.springBootDemo.controller;

import com.example.springBootDemo.dto.CategoriesDto;
import com.example.springBootDemo.service.ICategoriesService;
import com.example.springBootDemo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
  @Autowired
  private final ICategoriesService iCategoriesService;

  public CategoriesController(ICategoriesService iCategoriesService) {
    this.iCategoriesService = iCategoriesService;
  }

  @GetMapping("/getCategories")
  public Result<List<CategoriesDto>> getCategories() {
    return iCategoriesService.getCategories();
  }
}
