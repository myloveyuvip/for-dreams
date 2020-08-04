package com.yuliyao.designp.inaction;

import com.yuliyao.entity.User;

import java.util.Comparator;

/**
 * @author YuLiyao
 * @date 2020/8/3
 */
public class CollectionsDemo {





    public class AgeAscComparator implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return o1.getAge()-o2.getAge();
        }

    }

    public class NameAscComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
