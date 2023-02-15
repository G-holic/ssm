package cn.itcast.beforeaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {

    /**
     * 目标对象【目标客户】
     */
    private Object target;

    public MyProxy(Object target){
        this.target = target; // 写一个有参构造器，保证目标对象不为空
    }

    /**
     * 获取目标对象的代理对象
     * @return
     */

    public Object getProxyObject(){
        Object proxyObj = null;
        /*
        类加载器【ClassLoader loader】,  目标对象类加载器
        目标对象实现接口：Class<?>[] interfaces, 目标对象实现类所有接口
        InvocationHandler h)
        */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        // 直接使用匿名内部类
        // 创建代理对象
        proxyObj = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            // 执行invoke()实现动态织入效果
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 获取方法名【目标对象的方法名】
                String methodName = method.getName();
                // 执行目标方法之前，添加日志
                MyLogging.beforeMethod(methodName,args);
                // 触发目标对象的目标方法
                Object result = method.invoke(target, args);
                // 执行目标方法之后，添加日志
                MyLogging.afterMethod(methodName,result);
                return result;
            }
        });
        System.out.println("==============");
        System.out.println(proxyObj);
        System.out.println("==============");

        return proxyObj;

    }

//    class invocationImpl implements InvocationHandler{
//    }
}
