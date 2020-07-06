package com.yuliyao.java.basis.oper;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class OperationTest {


    @Test
    public void getObjectAddress() {
        Dog dog = new Dog();
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.hashCode());
        System.out.println(Integer.toHexString(dog.hashCode()));

    }

}