package com.geekluxun.guava.reflect;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-07-04 15:28
 * @Description: 动态代理示例
 * @Other:
 */
public class DynamicProxyDemo {
    public static void main(String[] argc) {
        DynamicProxyDemo demo = new DynamicProxyDemo();
        demo.demo1();
    }

    /**
     * 动态代理
     */
    private void demo1() {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new FooImpl());
        MyInvocationHandler2 myInvocationHandler2 = new MyInvocationHandler2(new FooImpl());

        // Guava
        Foo foo = Reflection.newProxy(Foo.class, myInvocationHandler2);
        foo.doSomething();

        // Guava
        foo = Reflection.newProxy(Foo.class, myInvocationHandler);
        foo.doSomething();

        // JDK 动态代理，只能代理实现了接口的类,不能代理其他普通类
        Foo foo1 = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class<?>[]{Foo.class}, myInvocationHandler);
        String result = foo1.doSomething();
        System.out.println();

    }

    public class MyInvocationHandler implements InvocationHandler {
        // 被代理的目标对象
        private Object proxyed;

        public MyInvocationHandler(Object proxyed) {
            this.proxyed = proxyed;
        }

        /**
         *
         * @param proxy
         * @param method
         * @param args
         * @return 是目标对象上的调用的目标方法的返回值
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("**** proxy1111: " + proxy.getClass() + ", method: " + method.getName() + ", args: " + args);
            System.out.println("======执行代理类逻辑1111=======");
            // 执行真正的被代理对象方法
            return method.invoke(proxyed, args);
        }
    }

    /**
     * Guava 实现的处理器
     */
    public class MyInvocationHandler2 extends AbstractInvocationHandler {
        private Object proxyed;

        public MyInvocationHandler2(Object proxyed) {
            this.proxyed = proxyed;
        }

        @Override
        protected Object handleInvocation(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("**** proxy2222: " + o.getClass() + ", method: " + method + ", args: " + objects);
            System.out.println("======执行代理类逻辑2222=======");
            // 执行真正的被代理对象方法
            return method.invoke(proxyed, objects);
        }
    }

    public class FooImpl implements Foo {
        @Override
        public String doSomething() {
            System.out.println("=======doSomething======");
            return "luxun";
        }
    }

    public interface Foo {
        String doSomething();
    }
}
