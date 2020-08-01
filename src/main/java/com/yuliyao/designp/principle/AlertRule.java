package com.yuliyao.designp.principle;

import com.google.common.collect.HashBasedTable;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class AlertRule {

    private int[][] metricLevelCount = {{1000,1000,50},{5000,500,20},{2000,200,10}};

    private HashBasedTable<AlertMetricEnum,AlertLevelEnum,Integer> hashBasedTable = HashBasedTable.create();

    {
        hashBasedTable.put(AlertMetricEnum.TPS, AlertLevelEnum.URGENT, 10000);
        hashBasedTable.put(AlertMetricEnum.TPS, AlertLevelEnum.SEVERE, 5000);
        hashBasedTable.put(AlertMetricEnum.TPS, AlertLevelEnum.WARN, 2000);
        hashBasedTable.put(AlertMetricEnum.ERROR_COUNT, AlertLevelEnum.URGENT, 1000);
        hashBasedTable.put(AlertMetricEnum.ERROR_COUNT, AlertLevelEnum.SEVERE, 500);
        hashBasedTable.put(AlertMetricEnum.ERROR_COUNT, AlertLevelEnum.WARN, 200);
        hashBasedTable.put(AlertMetricEnum.TIMEOUT_COUNT, AlertLevelEnum.URGENT, 50);
        hashBasedTable.put(AlertMetricEnum.TIMEOUT_COUNT, AlertLevelEnum.SEVERE, 20);
        hashBasedTable.put(AlertMetricEnum.TIMEOUT_COUNT, AlertLevelEnum.WARN, 10);
    }

    public int getThreshold(AlertMetricEnum alertMetricEnum, AlertLevelEnum levelEnum) {
        return hashBasedTable.get(alertMetricEnum, levelEnum);
    }
}
