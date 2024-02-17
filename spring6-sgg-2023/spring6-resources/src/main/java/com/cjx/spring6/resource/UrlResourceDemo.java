package com.cjx.spring6.resource;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

public class UrlResourceDemo {
    public static void main(String[] args) {
        //1.访问网络资源
//        loadAndReadUrlResource("http://www.baidu.com");
        //2.访问文件系统资源
        loadAndReadUrlResource("file:cjx.txt");
    }

    private static void loadAndReadUrlResource(String path) {
        //创建一个Resource对象
        UrlResource url = null;
        try {
            url = new UrlResource(path);
            //获取资源名
            System.out.println(url.getFilename());
            System.out.println(url.getURI());
            //获取资源描述
            System.out.println(url.getDescription());
            //获取资源内容
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
