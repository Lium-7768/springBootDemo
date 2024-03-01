package com.example.springBootDemo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  @TableField("username")
  private String username;

  @TableField("email")
  private String email;

  @TableField("password")
  private String password;

  @TableField("created_time")
  private LocalDateTime createdTime;

  @TableField("updated_time")
  private LocalDateTime updatedTime;

  @TableLogic // 标注逻辑删除字段
  private Integer isDelete;

}
