package com.example.springBootDemo.service;

import com.example.springBootDemo.entity.Resources;
import com.example.springBootDemo.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface IResourcesService extends IService<Resources> {
  Result<List<Resources>> getResources(long id);
}
