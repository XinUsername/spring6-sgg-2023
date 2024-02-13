package com.cjx.spring6.iocxml.dimap;

import java.util.List;
import java.util.Map;

public class Student {

    // 课程列表
    private List<Lesson> lessonList;
    private Map<String,Teacher> tMap;
    private Integer sid;
    private String sname;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Map<String, Teacher> gettMap() {
        return tMap;
    }

    public void settMap(Map<String, Teacher> tMap) {
        this.tMap = tMap;
    }

    public void run(){
        System.out.println("学生编号；"+sid+",学生姓名："+sname);
        System.out.println(tMap);
        System.out.println(lessonList);
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
