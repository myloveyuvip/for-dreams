package com.yuliyao.ringcentral;

/**
 * @author yuliyao
 * @date 2020/9/6
 */
public class MaxSalesStatistics extends AbstractSalesStatistics {


    @Override
    public Double statistic(double mapSales, double indexSales) {
        return Double.max(mapSales, indexSales);
    }
}
