package com.yuliyao.ringcentral;

/**
 * @author yuliyao
 * @date 2020/9/6
 */
public class SumSalesStatistics extends AbstractSalesStatistics {

    @Override
    public Double statistic(double mapSales, double indexSales) {
        Double result;
        if ((result = mapSales + indexSales) > Double.MAX_VALUE) {
            throw new IllegalArgumentException("Overflow occured");
        }
        return result;
    }
}
