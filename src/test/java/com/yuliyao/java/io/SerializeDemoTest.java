package com.yuliyao.java.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class SerializeDemoTest {

    private SerializeDemo demo = new SerializeDemo();

    @Test
    public void searialize() throws IOException, ClassNotFoundException {

        demo.searialize("F:\\test\\testSearialize.txt");

    }
}