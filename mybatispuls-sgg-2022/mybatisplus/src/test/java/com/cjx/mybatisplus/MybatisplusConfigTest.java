package com.cjx.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjx.mybatisplus.mapper.UserMapper;
import com.cjx.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisplusConfigTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> records = page.getRecords();
        records.forEach(System.out::print);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());
    }

    @Test
    public void testSelectPageVo(){
        //设置分页参数
        Page<User> page = new Page<>(1,5);
        userMapper.selectPageVo(page,20);
        //获取分页数据
        List<User> records = page.getRecords();
        records.forEach(System.out::print);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());
    }

}
