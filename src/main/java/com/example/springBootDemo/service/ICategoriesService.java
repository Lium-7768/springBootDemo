package com.example.springBootDemo.service;

import com.example.springBootDemo.dto.CategoriesDto;
import com.example.springBootDemo.entity.Categories;
import com.example.springBootDemo.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ICategoriesService extends IService<Categories> {
  Result<List<CategoriesDto>> getCategories();
}
