package com.yuliyao.java.lambda;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuliyao
 * @date 2020/8/4
 */
public class LambdaDemo {


    public void listStream() {
        List<String> list = new ArrayList<>();
        list.add("alice");
        list.add("bob");
        list.add("eve");
        list.add("steven");
        List<Integer> collect = list.stream().map(l -> l.length()).filter(l -> l > 4).collect(Collectors.toList());
        System.out.println(JSON.toJSON(collect));
    }


    public void execute(MyCallback myCallback) {

        System.out.println("pre callback...");
        myCallback.invoke();
        System.out.println("after callback...");
    }

    @FunctionalInterface
    public interface MyCallback{

        void invoke();

    }
}
