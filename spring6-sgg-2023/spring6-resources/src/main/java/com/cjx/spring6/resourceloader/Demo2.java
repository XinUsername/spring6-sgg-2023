package com.cjx.spring6.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Demo2 {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("cjx.txt");
        System.out.println(resource.getFilename());
    }
}
