package com.yuliyao.ringcentral;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuliyao
 * @date 2020/9/6
 */
public abstract class AbstractSalesStatistics {


    /**
     * statisticByQuarter
     * @param saleItems
     * @return
     */
    public Map<Integer, Double> statisticByQuarter(List<SaleItem> saleItems) {
        return statisticByMonths(saleItems, 3);
    }


    public Map<Integer, Double> statisticByMonths(List<SaleItem> saleItems, int months) {
        Map<Integer, Double> result = new HashMap<>(16);
        for (SaleItem saleItem : saleItems) {
            int everyMonths = saleItem.getMonth() / months;

            result.putIfAbsent(everyMonths, 0d);

            result.put(everyMonths, statistic(result.get(everyMonths), saleItem.getSaleNumbers()));
        }
        return result;
    }

    public abstract Double statistic(double mapSales, double indexSales);

}
