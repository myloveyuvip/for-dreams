package com.yuliyao.designp.oop;

/**
 * 里氏替换原则：子类对象必须能够替换掉所有父类对象。
 *
 * @author YuLiyao
 * @date 2020/7/20
 */
public class LspDemo extends LspParent {

    /**
     * 属性权限可以比父类更小，但是不符合里氏替换原则
     */
    private String foo;

    /**
     * 方法不能比父类权限更小，编译会报错
     * @return
     */
    /*@Override
    private String getFoo() {
        return foo;
    }*/


}
