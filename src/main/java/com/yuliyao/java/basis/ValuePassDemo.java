package com.yuliyao.java.basis;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 值传递
 *
 * @author YuLiyao
 * @date 2020/8/3
 */
public class ValuePassDemo {

    public void changeName(User user) {
        user.name = "changed";
    }

    /**
     * 不会改变传进行的对象
     * @param user
     */
    public void userToNull(User user) {
        user = null;
    }

    public static void main(String[] args) {
        User user = new User("alice", 20);
        ValuePassDemo valuePassDemo = new ValuePassDemo();
        valuePassDemo.changeName(user);
        System.out.println(JSON.toJSONString(user));
        valuePassDemo.userToNull(user);
        System.out.println(JSON.toJSONString(user));
    }


    @Data
    @AllArgsConstructor
    public static class User{
        private String name;
        private int age;
    }

}
