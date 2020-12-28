package com.yuliyao.ringcentral;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    /**
     * sort by firstName + lastName + ext,
     * if firstName is the same then sort by lastName and ext
     * lastName and ext can be empty string or null, null will be sorted by last
     *
     * @param extensions
     * @return
     */
    public static List<Extension> sortByName(List<Extension> extensions) {
        if (CollectionUtils.isEmpty(extensions)) {
            return extensions;
        }

        Comparator<Extension> comparator = Comparator.comparing(Extension::getFirstName)
                .thenComparing(Extension::getLastName, Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(Extension::getExt, Comparator.nullsLast(Comparator.naturalOrder()));
        extensions.sort(comparator);

        return extensions;
    }


    /**
     * sort extType, extType is a string and can be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     *
     * @param extensions
     * @return
     */
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        if (CollectionUtils.isEmpty(extensions)) {
            return extensions;
        }

        Comparator comparator = Comparator.comparing(o -> ExtTypeEnum.sortValueOf(((Extension) o).getExtType()));

        extensions.sort(comparator);

        return extensions;
    }

    /**
     * sum all sales items by quarter
     *
     * @param saleItems
     * @return
     */
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        List<QuarterSalesItem> result = new ArrayList<>();

        if (CollectionUtils.isEmpty(saleItems)) {
            return Collections.EMPTY_LIST;
        }

        SumSalesStatistics sumSalesStatistics = new SumSalesStatistics();
        Map<Integer, Double> quarterSaleSumMap = sumSalesStatistics.statisticByQuarter(saleItems);


        quarterSaleSumMap.entrySet().forEach(entry -> result.add(new QuarterSalesItem(entry.getKey(), entry.getValue())));

        return result;
    }


    /**
     * max all sales items by quarter
     * @param saleItems
     * @return
     */
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {

        List<QuarterSalesItem> result = new ArrayList<>();

        if (CollectionUtils.isEmpty(saleItems)) {
            return Collections.EMPTY_LIST;
        }

        MaxSalesStatistics maxSalesStatistics = new MaxSalesStatistics();
        Map<Integer, Double> quarterSaleMaxMap = maxSalesStatistics.statisticByQuarter(saleItems);


        quarterSaleMaxMap.entrySet().forEach(entry -> result.add(new QuarterSalesItem(entry.getKey(), entry.getValue())));

        return result;

    }

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :[2,3,4];
     * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        //check params
        if (allKeys == null || allKeys.length == 0) {
            return new int[0];
        }

        if (usedKeys == null || usedKeys.length == 0) {
            return allKeys;
        }

        Set<Integer> set = Arrays.stream(allKeys).boxed().collect(Collectors.toSet());
        for (int usedKey : usedKeys) {
            if (set.contains(usedKey)) {
                set.remove(usedKey);
            } else {
                set.add(usedKey);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
