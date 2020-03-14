package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

//@Component
public class MyClassThree {
    private Long id;
    private MyClassFour myClassFour;
    @Autowired
    private MyClassFour[] fourArrs;
    @Autowired
    private Set<MyClassFour> fourSets;
    @Autowired
    private Map<String,MyClassFour> foursMap;

    public MyClassThree() {
    }

    @Autowired(required = false)//required = false,找不到不会抛异常
    public MyClassThree(MyClassFour myClassFour) {
        System.out.println("MyClassThree构造方法:"+myClassFour);
        this.myClassFour = myClassFour;
    }


    public Long getId() {
        return id;
    }

    @Autowired
    @Required
    public void setId(@Value("666888") Long id) {
        this.id = id;
    }

    public MyClassFour getMyClassFour() {
        return myClassFour;
    }

    public MyClassFour[] getFourArrs() {
        return fourArrs;
    }

    public void setFourArrs(MyClassFour[] fourArrs) {
        this.fourArrs = fourArrs;
    }


    public Set<MyClassFour> getFourSets() {
        return fourSets;
    }

    public void setFourSets(Set<MyClassFour> fourSets) {
        this.fourSets = fourSets;
    }

    public Map<String, MyClassFour> getFoursMap() {
        return foursMap;
    }

    public void setFoursMap(Map<String, MyClassFour> foursMap) {
        this.foursMap = foursMap;
    }

    @Autowired(required = false)
    public void setMyClassFour(MyClassFour myClassFour) {
        System.out.println("MyClassThree set方法:"+myClassFour);
        this.myClassFour = myClassFour;
    }

    @Autowired
    public void findClass(MyClassTwo myClassTwo,MyClassFour myClassFour,@Qualifier("myClassFive2") MyClassFive myClassFive){
        System.out.println("findClass:"+myClassTwo+",findClass："+myClassFour+"，findClass:"+myClassFive);
    }

    @Bean(initMethod = "")
    public MyClassTwo creatMyClassTwo(){
        MyClassTwo two = new MyClassTwo();
        System.out.println("creatMyClassTwo:"+two);
        return two;
    }


    @Bean
    public MyClassFour creatMyClassFour(){
        MyClassFour four = new MyClassFour();
        System.out.println("creatMyClassFour:"+four);
        return four;
    }

    @Bean(name = "myClassFive1")
    //@Primary
    public MyClassFive findMyClassFive1(){
        MyClassFive five = new MyClassFive();
        System.out.println("findMyClassFive1:"+five);
        return five;
    }

    @Bean(name = "myClassFive2")
    public MyClassFive findMyClassFive2(){
        MyClassFive five = new MyClassFive();
        System.out.println("findMyClassFive2:"+five);
        return five;
    }

    //泛型用作自动装配限定符

    @Override
    public String toString() {
        return "MyClassThree{" +
                "id=" + id +
                ", myClassFour=" + myClassFour +
                ", myClassTwo=" + myClassTwo +
                '}';
    }


    @Autowired
    MyClassTwo myClassTwo;
}
