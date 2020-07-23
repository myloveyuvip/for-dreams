package com.yuliyao.designp.create;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果bigMap是从数据库或者其他耗资源的地方获取，此时需要创建一个一样的对象，可以使用原型模式进行创建
 * @author YuLiyao
 * @date 2020/7/22
 */
@ToString
public class PrototypeDemo {

    private Map<String, String> bigMap = new HashMap<>();

    public PrototypeDemo(Map<String, String> bigMap) {
        this.bigMap = bigMap;
    }

    public PrototypeDemo cloneMe() {
        //clone拷贝为浅拷贝，要进行深拷贝有两种方式：1.递归创建新对象 2.序列化反序列化
        Map<String, String> newMap = (Map<String, String>) ((HashMap) bigMap).clone();
        return new PrototypeDemo(newMap);
    }
}
