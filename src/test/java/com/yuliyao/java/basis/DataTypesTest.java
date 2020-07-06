package com.yuliyao.java.basis;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class DataTypesTest {

    DataTypes dataTypes = new DataTypes();

    @Test
    public void charType() {

        dataTypes.charType();
    }


    @Test
    public void charMethod() {
        dataTypes.charMethod('3');
    }

    @Test
    public void isDigital() {
        Assert.assertTrue(dataTypes.isDigital("1234"));
        Assert.assertFalse(dataTypes.isDigital("123c4"));
    }

    @Test
    public void byteType() {
        dataTypes.byteType();
    }

    @Test
    public void stringType() {
        dataTypes.stringType();
    }

}