package com.cjx.mybatisplusdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjx.mybatisplusdatasource.dao.UserMapper;
import com.cjx.mybatisplusdatasource.pojo.User;
import com.cjx.mybatisplusdatasource.service.UserService;
import org.springframework.stereotype.Service;

@DS("master") //指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
