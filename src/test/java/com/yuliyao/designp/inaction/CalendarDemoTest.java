package com.yuliyao.designp.inaction;

import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/8/3
 */
public class CalendarDemoTest {

    @Test
    public void testAssert() {
        assert 1==2;
    }

    @Test
    public void testGetDefaultZone() {
        TimeZone aDefault = TimeZone.getDefault();
        System.out.println(aDefault);
    }

}