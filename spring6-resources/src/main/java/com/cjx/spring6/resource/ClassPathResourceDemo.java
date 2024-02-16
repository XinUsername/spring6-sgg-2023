package com.cjx.spring6.resource;

import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;

public class ClassPathResourceDemo {
    public static void main(String[] args) throws Exception{
        loadAndReadUrlResource("cjx.txt");
    }

    private static void loadAndReadUrlResource(String path) throws Exception {
        //创建一个Resource对象
        ClassPathResource resource = new ClassPathResource(path);
        //获取文件名
        System.out.println("resource.getFilename = " + resource.getFilename());
        //获取文件描述
        System.out.println("resource.getDescription = " + resource.getDescription());
        //获取文件内容
        InputStream in = resource.getInputStream();
        byte[] b = new byte[1024];
        while (in.read(b)!=-1){
            System.out.println(new String(b));
        }
    }
}
