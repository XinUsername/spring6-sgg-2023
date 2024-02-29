package com.cjx.mybatisplusdatasource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjx.mybatisplusdatasource.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
