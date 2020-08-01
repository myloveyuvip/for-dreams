package com.yuliyao.designp.principle;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class TpsAlertHandler implements AlertHandler {



    @Override
    public void check(ApiMonitorInfo apiMonitorInfo) {
        for (Notificator notificator : notificators) {
            if (notificator.match(AlertMetricEnum.TPS, apiMonitorInfo.getTps())) {
                notificator.sendMsg();
                break;
            }
        }

    }
}
