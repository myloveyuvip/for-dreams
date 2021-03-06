package com.yuliyao.java.container;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author YuLiyao
 * @date 2020/7/6
 */
public class VectorDemo implements Runnable {

    private Vector<String> list = new Vector<>();


    @Override
    public void run() {
        for (String s : list) {
            if ("0".equals(s)) {
                list.remove(s);
            }
        }

    }

    public static void main(String[] args) {
        VectorDemo demo = new VectorDemo();
        for (int i = 0; i < 1; i++) {
            demo.getList().add(i + "");

        }
        //启个线程去删除list的元素
        new Thread(demo).start();

        for (int i = 0; i < demo.getList().size(); i++) {
            System.out.println(demo.getList().get(i));
        }

    }

    public Vector<String> getList() {
        return list;
    }

    public void setList(Vector<String> list) {
        this.list = list;
    }
}
