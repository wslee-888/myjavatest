package com.liws.other.otherBean;

public class ClassBean {

    //成员内部类
/*	* a:内部类可以直接访问外部类的成员，包括私有。
            * b:外部类要访问内部类的成员，必须创建对象。
            * 外部类名.内部类名 对象名 = 外部类对象.内部类对象;*/
    public class class1{

    }

    //静态内部类
    public static class class2{


    }

    //局部内部类
    public void test(){

        class class3{

        }

    }
}
