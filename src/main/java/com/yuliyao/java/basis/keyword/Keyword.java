package com.yuliyao.java.basis.keyword;

/**
 * @author YuLiyao
 * @date 2020/7/4
 */
public class Keyword {

    private String name;

    public static String staticFiled = "static";

    /**
     * private 方法隐式地被指定为 final
     * @return
     */
    private String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println(Keyword.staticFiled);
    }

    static class InnerClass{

    }

    public class InnerClass2{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
