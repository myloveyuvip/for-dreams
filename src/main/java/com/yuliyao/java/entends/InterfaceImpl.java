package com.yuliyao.java.entends;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class InterfaceImpl implements InterfaceExample {

    public static void main(String[] args) {
        InterfaceImpl anInterface = new InterfaceImpl();
        System.out.println(anInterface.getI());
        System.out.println(InterfaceImpl.i);


    }

}
