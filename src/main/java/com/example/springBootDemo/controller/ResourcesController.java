package com.example.springBootDemo.controller;

import com.example.springBootDemo.entity.Resources;
import com.example.springBootDemo.service.IResourcesService;
import com.example.springBootDemo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourcesController {
  @Autowired
  private final IResourcesService iResourcesService;

  public ResourcesController(IResourcesService iResourcesService) {
    this.iResourcesService = iResourcesService;
  }

  /**
   *
   * @param id id
   */
  @GetMapping("/getResource")
  public Result<List<Resources>> getResources(@RequestParam("id") long id) {
    System.out.println(id);
    return iResourcesService.getResources(id);
  }
}
