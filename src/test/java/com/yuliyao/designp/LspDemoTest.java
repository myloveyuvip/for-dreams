package com.yuliyao.designp;

import com.yuliyao.designp.oop.LspDemo;
import com.yuliyao.designp.oop.LspParent;
import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2020/7/20
 */
public class LspDemoTest {

    private LspDemo lspDemo = new LspDemo();

    @Test
    public void test() {
        lspDemo.setFoo("bar");
        //子类因为定义了private,不能直接访问
        /*String foo = lspDemo.foo;
        System.out.println(foo);*/
        LspParent parent = lspDemo;
//        System.out.println(parent.foo);
    }

}