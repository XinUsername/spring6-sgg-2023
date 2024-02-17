package com.cjx.spring6.resource;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourceDemo {
    public static void main(String[] args) throws IOException {
        loadAndReadUrlResource("cjx.txt");
    }

    private static void loadAndReadUrlResource(String path) throws IOException {
        //相对路径
        FileSystemResource resource1 = new FileSystemResource("cjx.txt");
        System.out.println("resource1.getFilename = " + resource1.getFilename());
        //绝对路径
        FileSystemResource resource2 = new FileSystemResource("F:\\java\\IntelliJ IDEA\\study\\spring6-sgg-2023\\cjx.txt");
        System.out.println("resource2.getFilename = " + resource2.getFilename());
        //获取文件描述
        System.out.println("resource2.getDescription" + resource2.getDescription());
        //获取文件内容
        InputStream inputStream = resource2.getInputStream();
        byte[] b = new byte[1024];
        while(inputStream.read(b) != -1){
            System.out.println(new String(b));
        }
    }
}
