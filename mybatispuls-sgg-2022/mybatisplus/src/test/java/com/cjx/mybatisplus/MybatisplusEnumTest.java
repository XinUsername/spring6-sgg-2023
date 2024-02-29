package com.cjx.mybatisplus;

import com.cjx.mybatisplus.enums.SexEnum;
import com.cjx.mybatisplus.mapper.UserMapper;
import com.cjx.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisplusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum(){
        User user = new User();
        user.setName("enum");
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("受影响的行数：" + result);
    }
}
