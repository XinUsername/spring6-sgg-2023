package com.cjx.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.cjx.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    //type = IdType.ASSIGN_ID 默认，雪花算法
    //type = IdType.AUTO 自增，确保数据库设置了自增
    private Long uid;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
    @TableLogic
    private Integer isDeleted;
}
