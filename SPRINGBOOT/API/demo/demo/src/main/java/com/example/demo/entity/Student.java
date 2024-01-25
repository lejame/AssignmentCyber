package com.example.demo.entity;

import java.util.List;
public class Student {
    private String name;
    private int age;
    private String phonenumber;
    public Student(String name,int age,String phonenumber){
        this.age = age;
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
