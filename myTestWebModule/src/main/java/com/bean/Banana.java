package com.bean;

public class Banana extends Fruit{
    public Banana() {
        System.out.println("I got a banana");
    }

    public void init(){
        System.out.println("Banana的init方法");
    }

    public void cleanUp(){
        System.out.println("Banana的cleanUp方法");
    }
}
