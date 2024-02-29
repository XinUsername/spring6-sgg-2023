package com.cjx.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cjx.mybatisplus.mapper.UserMapper;
import com.cjx.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisplusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含c，年龄在20到25之间，并且邮箱不为null的用户信息
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE
        // is_deleted=0 AND (username LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","c")
                .between("age",20,25)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::print);
    }

    @Test
    public void test02(){
        //查询用户信息，按照年龄降序排序，再按照id升序
        //SELECT id AS uid,name,age,email,is_deleted FROM user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::print);
    }

    @Test
    public void test03(){
        //删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test04(){
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name","c")
//                .gt("age",20)
//                .or()
//                .isNull("email");
//        User user = new User();
//        user.setAge(18);
//        user.setEmail("ccc@mail.com");
//        int result = userMapper.update(user, queryWrapper);
//        System.out.println("受影响的行数：" + result);

        //lambda表达式内的逻辑优先运算
        queryWrapper.like("name","c")
                .and(i -> i.gt("age",18).or().isNull("email"));
        User user = new User();
        user.setAge(20);
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test05(){
        //查询用户信息的user和age字段
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
//        System.out.println(maps);
        maps.forEach(System.out::print);
    }

    /**
     * 实现子查询
     */
    @Test
    public void test06(){
        //查询id小于等于3的用户信息
        //SELECT id AS uid,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (id IN (select id from user where id <= 3))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from user where id <= 3");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::print);
    }

    @Test
    public void test07(){
        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        //组装set子句以及修改条件
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("age",18)
                .set("email","18@mail.com")
                .like("name","c")
                .and(i -> i.gt("age",20).or().isNull("email"));
        //这里必须要创建User对象，否则无法应用自动填充。如果没有自动填充，可以设置为null
        //==>  Preparing: UPDATE user SET name=?, age=?,email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        //==> Parameters: 张三(String), 18(Integer), 18@mail.com(String), %c%(String), 20(Integer)
//        User user = new User();
//        user.setName("张三");
//        int result = userMapper.update(user, updateWrapper);
        //==>  Preparing: UPDATE user SET age=?,email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        //==> Parameters: 18(Integer), 18@mail.com(String), %c%(String), 20(Integer)
        int result = userMapper.update(null, updateWrapper);
        System.out.println("受影响的行数：" + result);
    }

    /**
     * condition
     * 思路一：
     */
    @Test
    public void test08(){
        //定义查询条件，有可能为null（用户为未输入或者未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 23;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断字符串是否不为空，且长度不为0，且不由空白符（whitespace）构成
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("name",username);
        }
        if(ageBegin != null){
            queryWrapper.ge("age",ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age",ageEnd);
        }
        //SELECT id AS uid,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::print);
    }

    /**
     * condition
     * 思路二：
     */
    @Test
    public void test09(){
        //定义查询条件，有可能为null（用户为未输入或者未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 23;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断字符串是否不为空，且长度不为0，且不由空白符（whitespace）构成
        queryWrapper.like(StringUtils.isNotBlank(username),"username",username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        //SELECT id AS uid,name,age,email,is_deleted FROM user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test10(){
        //LambdaQueryWrapper
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 23;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //避免使用字符串表示字段，防止运行时错误
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void test11(){
        //组装set子句
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(User::getName,"test")
                .like(User::getName,"cjx")
                .and(i -> i.lt(User::getAge,20).or().gt(User::getAge,25));
        int result = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("受影响的行数：" + result);
    }

}
