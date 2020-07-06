package com.yuliyao.java.oper;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class Operation {

    public void convert() {
//        float f = 1.1;
        float f = 1.1f;
        double d = 1.1;
        int i = (int) 1.1;
        short s = 1;
        //因为字面量 1 是 int 类型，它比 short 类型精度要高，因此不能隐式地将 int 类型向下转型为 short 类型
//        s = s + 1;
        //使用 += 或者 ++ 运算符隐式类型转换
        s += 1;

    }

}
