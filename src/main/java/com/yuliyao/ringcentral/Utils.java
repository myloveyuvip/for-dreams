package com.yuliyao.ringcentral;

import org.springframework.util.CollectionUtils;

import java.util.*;

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

        Map<Integer, Double> quarterSaleMap = sumByMonths(saleItems, 3);


        quarterSaleMap.entrySet().forEach(entry -> result.add(new QuarterSalesItem(entry.getKey(), entry.getValue())));

        return result;
    }


    /**
     * sum all sales items by every months
     *
     * @param saleItems
     * @param months
     * @return
     */
    private static Map<Integer, Double> sumByMonths(List<SaleItem> saleItems, int months) {
        Map<Integer, Double> result = new HashMap<>(16);
        for (SaleItem saleItem : saleItems) {
            int everyMonths = saleItem.getMonth() / months;

            result.putIfAbsent(everyMonths, 0d);

            Double everyMonthsSales;
            if ((everyMonthsSales = result.get(everyMonths) + saleItem.getSaleNumbers()) > Double.MAX_VALUE) {
                throw new IllegalArgumentException("Overflow occured");
            }

            result.put(everyMonths, everyMonthsSales);
        }
        return result;
    }

    /**
     * max all sales items by quarter
     * @param saleItems
     * @return
     */
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        return null;
    }

    //Question5

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :[2,3,4];
     * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        return null;
    }

}
