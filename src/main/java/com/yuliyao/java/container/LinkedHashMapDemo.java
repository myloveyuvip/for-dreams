package com.yuliyao.java.container;

import java.util.LinkedHashMap;

/**
 * @author yuliyao
 * @date 2020/7/5
 */
public class LinkedHashMapDemo {

    /**
     * accessOrder:顺序为插入顺序或者最近最少使用（LRU）顺序。 true-LRU
     */
    public void orderAccess() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(16,0.75f,true);
        linkedHashMap.put("1", 1);
        linkedHashMap.put("2", 2);
        linkedHashMap.put("3", 3);
        linkedHashMap.put("4", 4);
        linkedHashMap.get("3");
        linkedHashMap.get("2");
        System.out.println(linkedHashMap);
    }

    public static void main(String[] args) {
        LinkedHashMapDemo linkedHashMapDemo = new LinkedHashMapDemo();
        linkedHashMapDemo.orderAccess();
    }
}
