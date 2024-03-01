package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.dto.CategoriesDto;
import com.example.springBootDemo.entity.Categories;
import com.example.springBootDemo.mapper.CategoriesMapper;
import com.example.springBootDemo.service.ICategoriesService;
import com.example.springBootDemo.utils.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements ICategoriesService {
  @Autowired
  private final CategoriesMapper categoriesMapper;

  public CategoriesServiceImpl(CategoriesMapper categoriesMapper) {
    this.categoriesMapper = categoriesMapper;
  }

  @Override
  public Result<List<CategoriesDto>> getCategories() {
    List<Categories> Categories = categoriesMapper.selectList(null); // 自动过滤已逻辑删除的记录
    List<CategoriesDto> CategoriesDtoList = Categories.stream().map(user -> {
      CategoriesDto categoriesDto = new CategoriesDto();
      if (!user.getIsParent()) {
        categoriesDto.setParentId(user.getParentId());
      }
      categoriesDto.setId(user.getId());
      categoriesDto.setName(user.getName());
      // 设置其他属性
      return categoriesDto;
    })
        // 将流中的元素收集到一个 List中
        .collect(Collectors.toList());
    System.out.println(CategoriesDtoList);
    return Result.success(CategoriesDto.buildCategoriesDtoTree(CategoriesDtoList));
  }
}
