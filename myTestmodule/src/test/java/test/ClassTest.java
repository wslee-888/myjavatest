package test;


import other.ClassBean;

public class ClassTest {
    public static void main(String[] args) {
        ClassBean.class1 cc1 = new ClassBean().new class1();

        ClassBean.class2 cc2 = new ClassBean.class2();

        ClassBean cb1 = new ClassBean();
        cb1.test();

        //匿名内部类
        ClassBean cb2 = new ClassBean(){

            @Override
            public void test() {
                super.test();
            }
        };
    }
}
