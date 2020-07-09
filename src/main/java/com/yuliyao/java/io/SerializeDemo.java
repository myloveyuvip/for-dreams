package com.yuliyao.java.io;

import lombok.AllArgsConstructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class SerializeDemo implements Serializable{

    public void searialize(String dest) throws IOException, ClassNotFoundException {
        Foo larry = new Foo("larry", 30);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest));
        oos.writeObject(larry);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dest));
        Foo o = (Foo) ois.readObject();
        System.out.println(o);
    }

    @AllArgsConstructor
    class Foo implements Serializable {

        private String name;


        private transient int age;

        @Override
        public String toString() {
            return "Foo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
