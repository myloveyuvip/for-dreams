package com.yuliyao.designp.struct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class DynamicProxyDemo {


    public Object createProxy(Object proxyedObject) {
        ProxyHandler proxyHandler = new ProxyHandler(proxyedObject);
        return Proxy.newProxyInstance(proxyedObject.getClass().getClassLoader(), proxyedObject.getClass().getInterfaces(), proxyHandler);

    }

    private class ProxyHandler implements InvocationHandler{

        private Object object;

        public ProxyHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("----------> dynamic proxy begin");
            Object result = method.invoke(object, args);
            System.out.println("<---------- dynamic proxy end");
            return result;
        }
    }

}
