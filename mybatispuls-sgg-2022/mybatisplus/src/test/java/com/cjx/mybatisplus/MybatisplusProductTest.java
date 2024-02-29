package com.cjx.mybatisplus;

import com.cjx.mybatisplus.mapper.ProductMapper;
import com.cjx.mybatisplus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisplusProductTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testConcurrentUpdate(){
        //小李
        Product p1 = productMapper.selectById(1);
        System.out.println("小李取出的商品价格：" + p1.getId());
        //小王
        Product p2 = productMapper.selectById(1);
        System.out.println("小王取出的商品价格：" + p2.getId());
        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int count1 = productMapper.updateById(p1);
        System.out.println("小李影响的行数：" + count1);
        //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int count2 = productMapper.updateById(p2);
        //优化流程
        if(count2 == 0){
            //失败重试，重新获取version并更新
            p2 = productMapper.selectById(1);
            p2.setPrice(p2.getPrice() - 30);
            count2 = productMapper.updateById(p2);
        }
        System.out.println("小王影响的行数：" + count2);
        //最后结果
        Product product = productMapper.selectById(1);
        System.out.println("最总价格为：" + product.getPrice());
    }
}
