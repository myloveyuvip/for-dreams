package com.yuliyao.java.container;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Vector;

/**
 * @author yuliyao
 * @date 2020/7/5
 */
public class VectorDemo {

    public void testVector() {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        System.out.println(Arrays.toString(vector.toArray()));
        System.out.println(JSON.toJSONString(vector));
    }

    public static void main(String[] args) {
        VectorDemo vectorDemo = new VectorDemo();
        vectorDemo.testVector();
    }
}
