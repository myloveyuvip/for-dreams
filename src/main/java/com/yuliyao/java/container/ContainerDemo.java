package com.yuliyao.java.container;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * @author yuliyao
 * @date 2020/7/5
 */
public class ContainerDemo implements RandomAccess {

    public void list() {
        List<String> list = new ArrayList<>();
        list.add("haha");
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object next = listIterator.next();
            System.out.println(next);
        }

        for (String s : list) {
            System.out.println(s);
        }
    }


    /**
     * RandomAccess类是一个标记接口，我们可以用instanceof来判断决定访问方式
     * 其中ArrayList使用for循环遍历快，而LinkedList使用迭代器快
     */
    public void randomAccess() {

        ContainerDemo containerDemo = new ContainerDemo();
        System.out.println(containerDemo instanceof RandomAccess);

    }

    public static void main(String[] args) {
        ContainerDemo containerDemo = new ContainerDemo();
        containerDemo.list();

        containerDemo.randomAccess();
    }
}
