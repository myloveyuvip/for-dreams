package com.yuliyao.designp.principle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class NotificatorFactory {

    private static List<Notificator> notificators = new ArrayList<>();

    static {
        notificators.add(new MobileNotificator());
        notificators.add(new MsgNotificator());
        notificators.add(new DingNotificator());
    }

    public static Notificator getNotificator(AlertMetricEnum alertMetricEnum, int count) {
        for (Notificator notificator : notificators) {
            if (notificator.match(alertMetricEnum, count)) {
                return notificator;
            }
        }
        return null;
    }

}
