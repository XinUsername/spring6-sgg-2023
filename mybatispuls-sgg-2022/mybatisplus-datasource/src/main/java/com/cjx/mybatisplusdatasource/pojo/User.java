package com.cjx.mybatisplusdatasource.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer sex;
    @TableLogic
    private Integer is_deleted;
}
