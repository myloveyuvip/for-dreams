package com.yuliyao.designp.principle;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class DingNotificator implements Notificator {
    @Override
    public void sendMsg() {
        System.out.println("钉钉告警！");
    }

    @Override
    public boolean match(AlertMetricEnum alertMetricEnum, int count) {
        return count >= alertRule.getThreshold(alertMetricEnum, AlertLevelEnum.WARN);
    }
}
