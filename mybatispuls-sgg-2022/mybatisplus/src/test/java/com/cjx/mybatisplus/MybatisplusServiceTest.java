package com.cjx.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjx.mybatisplus.pojo.User;
import com.cjx.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MybatisplusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("count = " + count);

        User user = new User();
        user.setAge(22);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(user);
        long count1 = userService.count(userQueryWrapper);
        System.out.println(count1);
    }

    @Test
    public void testSaveBatch(){
        // SQL长度有限制，海量数据插入单条SQL无法实行，
        // 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("cjx" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);

    }
}
