package com.cjx.spring6.iocxml.di;

public class Book {
    private String bname;
    private String author;

    public Book() {
        System.out.println("无参构造执行了");
    }

    public Book(String bname, String author) {
        System.out.println("有参构造执行了");
        this.bname = bname;
        this.author = author;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //set方法注入
        Book book1 = new Book();
        book1.setBname("java");
        book1.setAuthor("ccc");

        //构造器注入
        Book book2 = new Book("python","cbc");
    }
}
