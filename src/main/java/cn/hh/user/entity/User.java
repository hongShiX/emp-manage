package cn.hh.user.entity;

import lombok.Data;

// 自动为字段添加set和get方法
@Data
public class User {
   private Integer id;
   private String username;
   private String password;
   private String chName;
}
