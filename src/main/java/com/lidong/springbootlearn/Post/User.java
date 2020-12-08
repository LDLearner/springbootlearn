package com.lidong.springbootlearn.Post;

import lombok.Data;
@Data
public class User {
    private String usename;
    private  String password;
    private String name;
    private  String age;
    //以下内容 因为引入了lombox框架而不需要再添加成员变量的get/set方法。
//    public String getUsename() {
//        return usename;
//    }
//
//    public void setUsename(String usename) {
//        this.usename = usename;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
}