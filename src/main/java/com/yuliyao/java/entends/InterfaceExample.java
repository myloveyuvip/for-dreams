package com.yuliyao.java.entends;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public interface InterfaceExample {

    /**
     * 接口中的成员变量默认public static
     */
    int i = 0;

    /**
     * 接口中的方法默认public
     * @return
     */
    default Integer getI(){
        return i;
    }

}
