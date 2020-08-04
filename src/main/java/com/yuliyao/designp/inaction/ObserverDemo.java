package com.yuliyao.designp.inaction;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author YuLiyao
 * @date 2020/8/3
 */
@Data
public class ObserverDemo extends Observable {


    private String msg;

    public static void main(String[] args) {

        ObserverDemo observerDemo = new ObserverDemo();
        observerDemo.addObserver(new Listener1());
        observerDemo.addObserver(new Listener2());
        observerDemo.setMsg("test");
        observerDemo.setChanged();
        observerDemo.notifyObservers();

    }

    public static class Listener1 implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("1接收到变化。"+ JSON.toJSONString(o));
        }
    }
    public static class Listener2 implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("2接收到变化。"+ JSON.toJSONString(o));
        }
    }

}
