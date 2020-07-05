package com.yuliyao.java.container;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author yuliyao
 * @date 2020/7/5
 */
public class ArrayListDemo {

    /**
     * 测试 list 扩容场景
     * 当 add 时，比对当前size+1是否比目前数组长度大，如果大则需要扩容，扩容大小于原数组大小的1.5倍。elementData.length 代表数组大小
     */
    public void testAddGrow() {
        List list = new ArrayList(1);
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }


    }

    public void testRemove() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        //反向删除
        for (int i = list.size() - 1; i > 0; i--) {
            if (i == 2) {
                list.remove(i);
            }
        }
        System.out.println(JSON.toJSONString(list));
        //iterator1 删除
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = (Integer) iterator.next();
            if (next == 3) {
                iterator.remove();
            }
        }
        System.out.println(JSON.toJSONString(list));
        //正向删除
        list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 2) {
                list.remove(i);
            }
        }
        System.out.println(JSON.toJSONString(list));

        ArrayList<String> al = new ArrayList<String>();
        al.add("1");
        al.add("1");
        al.add("1");
        al.add("1");
        al.add("4");
        al.add("1");
        al.add("6");
        //删除不完整
        /*for(int i=0;i<al.size();i++){
            if("1".equals(al.get(i))){
                al.remove(i);
            }
        }*/
        //删除完整
        for (int i = al.size() - 1; i >= 0; i--) {

            if ("1".equals(al.get(i))) {
                al.remove(i);
            }
        }
        System.out.println(Arrays.toString(al.toArray()));

        //Exception in thread "main" java.util.ConcurrentModificationException
        List<String> list1 = new ArrayList<String>();

        list1.add("111");
        list1.add("222");
        list1.add("222");
        list1.add("333");
        list1.add("444");
        list1.add("3331");
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals("222")) {
                list1.remove(i);
            }
        }
        //foreach循环删除
        Iterator iterator1 = list1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            if (next.equals("333")){
                iterator1.remove();
                //此处如果调用 arrayList 中的 remove 会抛错，因为
//                list1.remove(next);
            }
        }
        System.out.println(Arrays.toString(list1.toArray()));

    }


    public static void main(String[] args) {
        ArrayListDemo arrayListDemo = new ArrayListDemo();
        arrayListDemo.testAddGrow();

        arrayListDemo.testRemove();
    }
}
