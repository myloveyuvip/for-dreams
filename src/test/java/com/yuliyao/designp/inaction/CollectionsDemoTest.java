package com.yuliyao.designp.inaction;

import com.alibaba.fastjson.JSON;
import com.yuliyao.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 测试不可变集合，集合中的对象还是可以被改变的
 * @author YuLiyao
 * @date 2020/8/3
 */
public class CollectionsDemoTest {

    private List<User> users = new ArrayList<>();

    @Before
    public void before() {
        users.add(new User("bob", 20));
        users.add(new User("alice", 40));
        users.add(new User("eve", 30));
    }

    @Test
    public void testUnmodifiedCollection() {
        List<User> lists = new ArrayList<>();
        lists.add(new User("foo",10));
        lists.add(new User("bar", 20));
        lists.add(new User("alice", 30));
        Collection<User> unmodCols = Collections.unmodifiableCollection(lists);
        for (User user : unmodCols) {
            if ("foo".equals(user.getName())) {
                user.setName("bob");
            } else if ("bar".equals(user.getName())) {
            }
        }
        System.out.println(JSON.toJSONString(unmodCols));
    }

    @Test
    public void testComparator() {
        CollectionsDemo collectionsDemo = new CollectionsDemo();
        Collections.sort(users, collectionsDemo.new AgeAscComparator());
        System.out.println(JSON.toJSONString(users));

        Collections.sort(users, collectionsDemo.new NameAscComparator());
        System.out.println(JSON.toJSONString(users));

    }



}