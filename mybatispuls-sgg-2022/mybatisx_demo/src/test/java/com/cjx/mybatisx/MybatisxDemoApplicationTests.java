package com.cjx.mybatisx;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.cjx.mybatisx.domain.User;
import com.cjx.mybatisx.mapper.UserMapper;
import com.cjx.mybatisx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisxDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testinsertSelective() {
//        User user1 = new User();
//        user1.setId(6L);
//        user1.setName("mybatisx");
//        user1.setAge(18);
//        user1.setSex(2);
//        // 自定义方法，雪花算法不生效
//        int result = userMapper.insertSelective(user1);
//        System.out.println("结果为："+ result);
//        // mybatisplus自带方法则生效
//        User user2 = new User();
//        user2.setName("mybatisx");
//        user2.setAge(18);
//        user2.setSex(2);
//        int result2 = userMapper.insert(user2);
//        System.out.println("影响行数：" + result2);
        // 调用mybatis底层使用的雪花算法
        User user3 = new User();
        user3.setName("mybatisx");
        user3.setAge(18);
        user3.setSex(2);
        IdentifierGenerator identifierGenerator=new DefaultIdentifierGenerator();
        user3.setId(identifierGenerator.nextId(new Object()).longValue());
        int result3 = userMapper.insertSelective(user3);
        System.out.println("影响行数：" + result3);
    }

    @Test
    public void testSelectNameAndAgeByIdBetweenOrderByIdDesc(){
        List<User> users = userMapper.selectNameAndAgeByIdBetweenOrderByIdDesc(1L, 8L);
        users.forEach(System.out::print);
    }

    @Test
    public void testUpdateNameAndEmailByNameLike(){
        int result = userMapper.updateNameAndEmailByNameLike("over", "over@email.com", "cjx");
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testDeleteByNameAndIsDeletedNot(){
        int result = userMapper.deleteByNameAndIsDeletedNot("cjx",0);
        System.out.println("受影响的行数：" + result);
    }
}
