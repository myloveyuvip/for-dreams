package com.yuliyao.designp.struct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuLiyao
 * @date 2020/7/23
 */
public class EventBusDemoTest {

    @Before
    public void setup() {
        System.out.println("set up");
    }

    @Test
    public void regUser() {

        EventBusDemo eventBusDemo = new EventBusDemo();

        List<Object> observers = new ArrayList<>();
        observers.add(new EventBusDemo.PromotionService());
        observers.add(new EventBusDemo.WelcomeMsgService());
        eventBusDemo.setObservers(observers);

        eventBusDemo.regUser("余先生");

    }

    @After
    public void tearDown() {
        System.out.println("tear down");
    }
}