package com.yuliyao.designp.principle;

/**
 * 里氏替换原则
 * @author YuLiyao
 * @date 2020/7/31
 */
public class LSPDemo {

    public interface Animal{
        void eat();
    }

    public static class Cat implements Animal {
        @Override
        public void eat() {
            System.out.println("I am cat,I can eat");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();
    }


}
