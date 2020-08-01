package com.yuliyao.designp.principle;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public interface Notificator {

    public void sendMsg();

    /**
     * 是否符合本告警器
     * @param alertMetricEnum
     * @param count
     * @return
     */
    boolean match(AlertMetricEnum alertMetricEnum, int count);

    AlertRule alertRule = new AlertRule();

}
