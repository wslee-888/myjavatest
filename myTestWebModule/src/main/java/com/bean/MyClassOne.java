package com.bean;

import org.springframework.beans.factory.annotation.Required;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Map;

public class MyClassOne {

    private Long id;
    private Integer status;
    private String str;
    private MyClassTwo myClassTwo;
    private List<MyClassTwo> classTwoList;

    public MyClassOne() {
        //System.out.println("MyClassOne1:"+this);
    }

    //@ConstructorProperties({"status", "str"})
    public MyClassOne(Integer status,String str) {
        System.out.println("MyClassOne2:"+myClassTwo);
        this.status = status;
        this.str = str;

    }

    public MyClassOne(MyClassTwo myClassTwo) {
        System.out.println("MyClassOne3:"+myClassTwo);
    }

    public MyClassOne(MyClassTwo myClassTwo,MyClassThree myClassThree) {
        System.out.println("MyClassOne4:"+myClassTwo);
        System.out.println(myClassTwo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public List<MyClassTwo> getClassTwoList() {
        return classTwoList;
    }

    public void setClassTwoList(List<MyClassTwo> classTwoList) {
        System.out.println("setClassTwoList:"+classTwoList.size());
        this.classTwoList = classTwoList;
    }

    public MyClassTwo getMyClassTwo() {
        return myClassTwo;
    }

    public void setMyClassTwo(MyClassTwo myClassTwo) {
        System.out.println("myclassOne setMyClassTwo方法："+myClassTwo);
        this.myClassTwo = myClassTwo;
    }

    public void setMyClassTwo666(MyClassTwo myClassTwo) {
        System.out.println("myclassOne setMyClassTwo666方法："+myClassTwo);
        this.myClassTwo = myClassTwo;
    }
}
