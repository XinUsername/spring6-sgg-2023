package com.cjx.spring6.iocxml.ditest;

import java.util.Arrays;

public class Emp {

    //对象类型属性：员工所在部门
    private Dept dept;

    private String name;
    private String age;

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    // 爱好
    private String[] loves;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void work(){
        System.out.println(name+"在工作..."+age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }
}
