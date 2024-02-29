package com.cjx.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjx.mybatisx.domain.User;
import com.cjx.mybatisx.service.UserService;
import com.cjx.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author star
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-02-29 11:59:31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




