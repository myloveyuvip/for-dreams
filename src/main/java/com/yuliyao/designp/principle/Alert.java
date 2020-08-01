package com.yuliyao.designp.principle;

import java.util.ArrayList;
import java.util.List;

/**
 * 告警类
 * 告警渠道：电话、短信、钉钉
 * 告警条件：tps、errorCount、timeoutCount
 * 触发规则：tps>1w：电话
 * @author YuLiyao
 * @date 2020/7/31
 */
public class Alert {

    private static Alert alert = new Alert();

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    private Alert(){
        initNotifications();
    }

    private void initNotifications() {
        alertHandlers.add(new TpsAlertHandler());
        alertHandlers.add(new ErrorCountAlertHandler());
        alertHandlers.add(new TimeoutAlertHandler());
    }

    public static Alert getInstance() {
        return alert;
    }

    public void check(ApiMonitorInfo apiMonitorInfo) {
        for (AlertHandler alertHandler : alertHandlers) {
            alertHandler.check(apiMonitorInfo);
        }
    }
}
