import com.liws.reflect.TestReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflectTest {

    public static void main(String[] args) {
        Class c = TestReflect.class;
        //Constructor constructor = c.getConstructor();
        Constructor[] constructors =c.getConstructors();

        Field[] allFields = c.getDeclaredFields();
        Field[] fields = c.getFields();

        Method[] allMethods = c.getDeclaredMethods();
        Method[] methods = c.getMethods();

        for (Field field:allFields) {
            System.out.println("allFields:"+field.getName());
        }

        for (Field field:fields) {
            System.out.println("fields:"+field.getName());
        }

        for (Method method :allMethods) {
            System.out.println("allMethods:"+method.getName());
        }

        for (Method method :methods) {
            System.out.println("methods:"+method.getName());
        }
    }
}
