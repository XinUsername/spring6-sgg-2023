package com.atguigu.spring6.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {
    public static void main(String[] args) {
        String string1 = ResourceBundle.getBundle("message", new Locale("en", "GB")).getString("test");
        System.out.println(string1);
        String string2 = ResourceBundle.getBundle("message", new Locale("zh", "CN")).getString("test");
        System.out.println(string2);
    }
}
