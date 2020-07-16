package com.yuliyao.java.jvm;

/**
 * @author YuLiyao
 * @date 2020/7/11
 *
 */
public class ConstantDemo {

    /**
     * 常量。初始化后不能改变。两种初始化方式：1.直接赋值；2.构造方法赋值
     * 常量放在方法区
     */
    public final int i = 0;

    public final int i2;

    public ConstantDemo(int i2) {
        this.i2 = i2;
    }

    public void testChange() {
        //编译报错
//        i = 3;
//        i2 = 3;
    }
}
