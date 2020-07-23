package com.yuliyao.designp.create;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class LombokBuilderDemoTest {

    @Test
    public void create() {
        LombokBuilderDemo testPool = LombokBuilderDemo.builder().name("testPool").build();
        System.out.println(testPool.toString());

    }


}