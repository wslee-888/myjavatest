import com.application.MyAopConfig;
import com.application.MyAspect;
import com.service.MyServiceInterFaceIml;
import com.service.MyServiceInterface;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyTest {
    public static void main(String[] args) throws Exception{
       /* List<String> strList = new ArrayList<>();
        for (String str: strList){
            System.out.println(str);
        }

        System.out.println("测试git2的使用，哈哈哈");*/

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/my_spring_context.xml");
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

        //MyEventPublisherService publisherService = context.getBean(MyEventPublisherService.class);
        //publisherService.sendEmail("known.spammer@example.org","哈哈哈哈哈哈哈");




         //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAopConfig.class);

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


//        context.getEnvironment().setActiveProfiles("dev","pro","test");
//        context.register(MyAppConfigThree.class);
//        context.refresh();
//
//        System.out.println(context.getBean(Apple.class));
//        System.out.println(context.getBean(Banana.class));
//        System.out.println(context.getBean(Orange.class));


        //代码添加环境配置
/*        ConfigurableApplicationContext ctx = new GenericApplicationContext();
        MutablePropertySources sources = ctx.getEnvironment().getPropertySources();
        sources.addFirst(new MyPropertySource());*/
        //Environment environment = context.getEnvironment();
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = context.getBean(PropertySourcesPlaceholderConfigurer.class);
//        DriverManagerDataSource driverManagerDataSource = context.getBean(DriverManagerDataSource.class);
//
//
//        PropertySource<?> localProperties = propertySourcesPlaceholderConfigurer.getAppliedPropertySources().get("localProperties");
//
//
//        System.out.println("appName:"+localProperties.getProperty("appName"));
//        System.out.println("version:"+localProperties.getProperty("version"));
//        System.out.println("author:"+localProperties.getProperty("author"));
//        System.out.println("updateTime:"+localProperties.getProperty("updateTime"));
//        System.out.println("target:"+localProperties.getProperty("target"));
//
//        System.out.println("jdbc.driverClassName:"+localProperties.getProperty("jdbc.driverClassName"));
//        System.out.println("jdbc.url:"+localProperties.getProperty("jdbc.url"));
//        System.out.println("jdbc.username:"+localProperties.getProperty("jdbc.username"));
//        System.out.println("jdbc.password:"+localProperties.getProperty("jdbc.password"));
//
//        System.out.println("datasource_url:"+driverManagerDataSource.getUrl());
//        System.out.println("datasource_username:"+driverManagerDataSource.getUsername());
//        System.out.println("datasource_password:"+driverManagerDataSource.getPassword());


//        MessageSource messageSource = new ClassPathXmlApplicationContext("spring/my_spring_context.xml");
//
//        System.out.println(messageSource.getMessage("hello",null,Locale.CHINESE));

        //DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //factory.addBeanPostProcessor(new MyBeanPostProcessor());

//        MyServiceInterface myService = context.getBean(MyServiceInterface.class);
//        myService.testOne();

        MyServiceInterface serviceInterface = context.getBean(MyServiceInterface.class);
        serviceInterface.testOne();

    }
}
