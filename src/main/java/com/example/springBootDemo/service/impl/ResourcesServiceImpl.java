package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.entity.Resources;
import com.example.springBootDemo.mapper.ResourcesMapper;
import com.example.springBootDemo.service.IResourcesService;
import com.example.springBootDemo.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {
  @Autowired
  private final ResourcesMapper resourcesMapper;

  public ResourcesServiceImpl(ResourcesMapper resourcesMapper) {
    this.resourcesMapper = resourcesMapper;
  }

  @Override
  public Result<List<Resources>> getResources(long id) {
    QueryWrapper<Resources> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("category_id", id);
    return Result.success(resourcesMapper.selectList(queryWrapper));
  }
}
