package com.yuliyao.designp.create;

import com.yuliyao.designp.struct.Animal;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class PrototypeDemoTest {

    @Test
    public void testClone() {
        Map<String,String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        PrototypeDemo demo = new PrototypeDemo(map);

        PrototypeDemo cloneDemo = demo.cloneMe();
        System.out.println(cloneDemo);
    }

    @Test
    public void testGenerateProxy() throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("TestProxy", new Class[]{Animal.class});
        FileOutputStream fos = new FileOutputStream("F:\\test\\TestProxy.class");
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

}