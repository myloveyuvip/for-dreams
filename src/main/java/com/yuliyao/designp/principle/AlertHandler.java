package com.yuliyao.designp.principle;

import java.util.Arrays;
import java.util.List;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public interface AlertHandler {

    /**
     * 检查告警
     * @param apiMonitorInfo
     */
    public void check(ApiMonitorInfo apiMonitorInfo);

    List<Notificator> notificators = Arrays.asList(new MobileNotificator(),new MsgNotificator(),new DingNotificator());

}
