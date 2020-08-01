package com.yuliyao.designp.principle;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class MobileNotificator implements Notificator {

    @Override
    public void sendMsg() {
        System.out.println("电话告警！");
    }

    @Override
    public boolean match(AlertMetricEnum alertMetricEnum, int count) {
        return count >= alertRule.getThreshold(alertMetricEnum, AlertLevelEnum.URGENT);
    }
}
