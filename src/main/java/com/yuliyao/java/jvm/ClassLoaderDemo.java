package com.yuliyao.java.jvm;

import netscape.javascript.JSUtil;
import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @author yuliyao
 * @date 2020/7/12
 */
public class ClassLoaderDemo {

    public void getClassLoader() {
        //lib包
        System.out.println(JSUtil.class.getClassLoader());
        //ext 包
        System.out.println(DNSNameService.class.getClassLoader());
        //classpath 下
        System.out.println(ClassLoaderDemo.class.getClassLoader());
    }
}
