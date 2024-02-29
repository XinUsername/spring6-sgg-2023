package com.cjx.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjx.mybatisplus.mapper.UserMapper;
import com.cjx.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //selectList()根据MP内置的条件构造器查询一个list集合，null表示没有条件，即查询所有
        userMapper.selectList(null).forEach(System.out::print);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@qq.com");
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        int result = userMapper.insert(user);
        System.out.println("受影响的行数：" + result);
        System.out.println("id自动获取：" + user.getUid());//1762655506433044481
    }

    @Test
    public void testDeleteBatchIds(){
        //通过多个id删除
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        //添加TableLogic后，SQL语句变成update
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testDeleteByMap(){
        //根据map集合中所设置的条件删除
        //DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age",23);
        map.put("name","张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testUpdateById(){
        //根据id进行修改
        User user = new User();
        user.setUid(4L);
        user.setName("admin");
        user.setAge(22);
        user.setEmail("zhangsan@qq.com");
        //UPDATE user SET name=?, age=? WHERE id=?
        int result = userMapper.updateById(user);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void testSelectById(){
        //根据id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(4);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds(){
        //根据多个id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> users = userMapper.selectBatchIds(idList);
        users.forEach(e -> System.out.println(e));
        //lambda简写
        users.forEach(System.out::print);
    }

    @Test
    public void testSelectByMap(){
        //通过map条件查询用户信息
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("age",22);
        map.put("name","admin");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::print);
    }

    @Test
    public void testSelectList2(){
        //查询所有用户信息
        //SELECT id,name,age,email FROM user
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::print);
    }

    @Test
    public void testSelectCount(){
        //SELECT COUNT( * ) FROM user
//        Long count = userMapper.selectCount(null);
        //SELECT COUNT( * ) FROM user WHERE age=?
        User user = new User();
        user.setAge(22);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(user);
        Long count = userMapper.selectCount(userQueryWrapper);
        System.out.println("count = " + count);
    }

    @Test
    public void testCustomMethod(){
        //测试自定义方法
        Map<String, Object> map = userMapper.selectMapById(4L);
        System.out.println(map);
    }


    @Test
    void contextLoads() {
    }

}
