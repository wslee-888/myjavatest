import com.applicaton.MyAppConfig;
import com.applicaton.MyAppConfigOne;
import com.applicaton.MyApplication;
import com.bean.*;
import com.lifecycle.MyLifeClassOne;
import com.service.MyServiceInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Map;
import java.util.Set;

public class MyTest {
    public static void main(String[] args) throws Exception{
       /* List<String> strList = new ArrayList<>();
        for (String str: strList){
            System.out.println(str);
        }

        System.out.println("测试git2的使用，哈哈哈");*/

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/my_spring_context.xml","spring/my_spring_database.xml");
//        MyClassOne myClassOne = context.getBean(MyClassOne.class);
//        System.out.println(myClassOne);

        //System.out.println(myClassOne.getId()+","+myClassOne.getMyClassTwo());

//        List<MyClassTwo> classTwos = myClassOne.getClassTwoList();
//        for(MyClassTwo classTwo:classTwos){
//            System.out.println("集合自动布线classTwos："+classTwo);
//        }

        /*MyClassTwo myClassTwo1 = (MyClassTwo) context.getBean("myClassTwo1");
        System.out.println(myClassTwo1);

        MyClassTwo myClassTwo2 = (MyClassTwo) context.getBean("myClassTwo2");
        System.out.println(myClassTwo2);

        MyClassTwo myClassTwo3 = (MyClassTwo) context.getBean("myClassTwo3");
        System.out.println(myClassTwo3);

        MyClassTwo myClassTwo4 = (MyClassTwo) context.getBean("myClassTwo4");
        System.out.println(myClassTwo4);

        MyClassTwo myClassTwo5 = (MyClassTwo) context.getBean("myClassTwo5");
        System.out.println(myClassTwo5);

        MyClassTwo myClassTwo6 = (MyClassTwo) context.getBean("myClassTwo6");
        System.out.println(myClassTwo6);*/

/*        FruitPlate fruitPlate1 = (FruitPlate) context.getBean("fruitPlate1");

        FruitPlate fruitPlate2 = (FruitPlate) context.getBean("fruitPlate2");

        fruitPlate1.getFruit();
        fruitPlate2.getFruit();*/

/*      MyConfigurableBeanFactory beanFactory = new MyConfigurableBeanFactory();
        MySpringBeanScope myScope = new MySpringBeanScope();

        beanFactory.registerScope("myScope",myScope);*/

/*      ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext("my_spring_context.xml");

        configurableApplicationContext.registerShutdownHook();*/

//        MyClassTwo myClassTwo = context.getBean(MyClassTwo.class);
//        System.out.println(myClassTwo);


//        MyClassTwo myClassTwo = (MyClassTwo) context.getBean("myClassTwo");
//        System.out.println(myClassTwo);

//        MyClassThree myClassThree = (MyClassThree) context.getBean("myClassThree");
//        System.out.println(myClassThree);

//        MyClassThree myClassThree = context.getBean(MyClassThree.class);
//        System.out.println(myClassThree);


//        MyClassFour[] fourArrs = myClassThree.getFourArrs();
//        System.out.println(fourArrs.length);
//
//        for (MyClassFour four:fourArrs){
//            System.out.println("fourArrs:"+four);
//        }
//
//        Set<MyClassFour> fourSets = myClassThree.getFourSets();
//        System.out.println(fourSets.size());
//
//        for (MyClassFour four:fourSets){
//            System.out.println("fourSets:"+four);
//        }
//
//
//        Map<String, MyClassFour> fourMaps = myClassThree.getFoursMap();
//        System.out.println(fourMaps.size());
//
//        for (String key:fourMaps.keySet()){
//            System.out.println("fourMaps key:"+key+",fourMaps value:"+fourMaps.get(key));
//        }

//        MyLifeClassOne lifeClassOne = context.getBean(MyLifeClassOne.class);
//        System.out.println(lifeClassOne);
//        context.close();

//        MyClassFive myClassFive = (MyClassFive) context.getBean("myClassFive");
//        System.out.println(myClassFive.getMyClassSix());
//
//        System.out.println(myClassFive.getMyClassSix().getDriverClassName());
//        System.out.println(myClassFive.getMyClassSix().getUrl());

        //DriverManagerDataSource driverManagerDataSource = context.getBean(DriverManagerDataSource.class);
        //System.out.println(driverManagerDataSource.getUrl()+","+driverManagerDataSource.getUsername()+","+driverManagerDataSource.getPassword());





         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);

          //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyClassSix.class,MyClassEight.class);
          //System.out.println(context.getBean(MyClassFive.class));
          //System.out.println(context.getBean(MyClassSix.class));

        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.register(MyAppConfig.class);

        //context.scan("com");
        //context.refresh();

        //MyClassFive classFive = context.getBean(MyClassFive.class);
        //System.out.println(classFive);
        //MyServiceInterface myServiceInterface = context.getBean(MyServiceInterface.class);
        //System.out.println(myServiceInterface);

     /*   System.out.println(context.getBean(Apple.class));
        System.out.println(context.getBean(Banana.class));

        context.getBean(MyAppConfig.class).getFruit();*/
        //System.out.println(context.getBean(Apple.class));
        //System.out.println(context.getBean(Banana.class));
        //System.out.println(context.getBean(MyAppConfig.class));
    }
}
