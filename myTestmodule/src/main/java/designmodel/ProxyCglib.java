package designmodel;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyCglib implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }

    public static void main(String[] args) {
        ProxyCglib proxyCglib = new ProxyCglib();
        Enhancer enhancer = new Enhancer();
        //enhancer.setSuperclass();//设置目标类
        enhancer.setCallback(proxyCglib);//设置代理

        enhancer.create();//得到代理
    }
}
