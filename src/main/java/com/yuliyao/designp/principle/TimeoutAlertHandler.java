package com.yuliyao.designp.principle;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class TimeoutAlertHandler implements AlertHandler {



    @Override
    public void check(ApiMonitorInfo apiMonitorInfo) {
        for (Notificator notificator : notificators) {
            if (notificator.match(AlertMetricEnum.TIMEOUT_COUNT, apiMonitorInfo.getTimeoutCount())) {
                notificator.sendMsg();
                break;
            }
        }

    }
}
