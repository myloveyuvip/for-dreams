package com.yuliyao.designp.struct;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * guava Event Bus demo
 *
 * @author YuLiyao
 * @date 2020/7/23
 */
public class EventBusDemo {

    private EventBus eventBus = new EventBus();



    public void regUser(String name) {
        System.out.println("进行用户注册...");

        //使用EventBus通知
        eventBus.post(name);

    }


    public void setObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public static class PromotionService{

        /**
         * 发放优惠券
         */
        @Subscribe
        public void sendTicket(String userName) {
            System.out.println(userName+"，你好！送您一张500-2优惠券");
        }
    }

    public static class WelcomeMsgService{

        /**
         * 发送欢迎短信
         */
        @Subscribe
        public void sendWelcomeMsg(String userName) {
            System.out.println(userName+"，恭喜你注册成功！");
        }
    }
}
