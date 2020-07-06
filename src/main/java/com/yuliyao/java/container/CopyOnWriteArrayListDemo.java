package com.yuliyao.java.container;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author YuLiyao
 * @date 2020/7/6
 */
public class CopyOnWriteArrayListDemo implements Runnable {

    private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


    @Override
    public void run() {
        for (String s : list) {
            if ("0".equals(s)) {
                list.remove(s);
            }
        }

    }

    public static void main(String[] args) {
        CopyOnWriteArrayListDemo demo = new CopyOnWriteArrayListDemo();
        for (int i = 0; i < 1; i++) {
            demo.getList().add(i + "");

        }
        //启个线程去删除list的元素
        new Thread(demo).start();

        for (int i = 0; i < demo.getList().size(); i++) {
            System.out.println(demo.getList().get(i));
        }

    }

    public CopyOnWriteArrayList getList() {
        return list;
    }

    public void setList(CopyOnWriteArrayList list) {
        this.list = list;
    }
}
