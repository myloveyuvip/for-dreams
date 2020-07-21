package com.yuliyao.designp.create;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/20
 */
public class SingletonEnumTest {

    @Test
    public void testSingleton() {
        SingletonEnum firstIns = SingletonEnum.INSTANCE;
        firstIns.setObjectName("firstInstance");
        System.out.println(firstIns.getObjectName());
        SingletonEnum secondIns = SingletonEnum.INSTANCE;
        secondIns.setObjectName("secondInstance");
        System.out.println(firstIns.getObjectName());
        System.out.println(secondIns.getObjectName());
        System.out.println(firstIns == secondIns);

        SingletonEnum[] enumConstants = SingletonEnum.class.getEnumConstants();
        for (SingletonEnum enumConstant : enumConstants) {
            System.out.println(enumConstant.getObjectName());
        }
    }

}