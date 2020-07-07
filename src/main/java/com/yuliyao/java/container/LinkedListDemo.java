package com.yuliyao.java.container;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author YuLiyao
 * @date 2020/7/7
 */
public class LinkedListDemo {

    public void testUse() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        System.out.println(list.get(1));
        Iterator iterator = list.iterator();
    }

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.testUse();
    }
}
