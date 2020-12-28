package com.yuliyao.ringcentral;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuliyao
 * @date 2020/9/5
 */
public class UtilsTest {

    @Test
    public void sortByName() {
        Extension extension1 = Extension.builder().firstName("ca").build();
        Extension extension2 = Extension.builder().firstName("aa").build();
        Extension extension3 = Extension.builder().firstName("ba").build();
        Extension extension4 = Extension.builder().firstName("ab").build();
        List<Extension> extensions = Utils.sortByName(Arrays.asList(extension1, extension2, extension3, extension4));
        Assert.assertEquals("aa", extensions.get(0).getFirstName());
        Assert.assertEquals("ab", extensions.get(1).getFirstName());
        Assert.assertEquals("ba", extensions.get(2).getFirstName());
        Assert.assertEquals("ca", extensions.get(3).getFirstName());

    }

    @Test
    public void sortByName_listNull() {
        List<Extension> extensions = Utils.sortByName(null);
        Assert.assertNull(extensions);
    }


    @Test
    public void sortByName_firstNameIsSame() {
        Extension extension1 = Extension.builder().firstName("aa").lastName("ca").build();
        Extension extension2 = Extension.builder().firstName("aa").lastName("aa").build();
        Extension extension3 = Extension.builder().firstName("aa").lastName("ba").build();
        Extension extension4 = Extension.builder().firstName("aa").lastName("ab").build();
        List<Extension> extensions = Utils.sortByName(Arrays.asList(extension1, extension2, extension3, extension4));
        Assert.assertEquals("aa", extensions.get(0).getLastName());
        Assert.assertEquals("ab", extensions.get(1).getLastName());
        Assert.assertEquals("ba", extensions.get(2).getLastName());
        Assert.assertEquals("ca", extensions.get(3).getLastName());
    }

    @Test
    public void sortByName_firstNameLastNameIsSame() {
        Extension extension1 = Extension.builder().firstName("aa").lastName("bb").ext("ca").build();
        Extension extension2 = Extension.builder().firstName("aa").lastName("bb").ext("aa").build();
        Extension extension3 = Extension.builder().firstName("aa").lastName("bb").ext("ba").build();
        Extension extension4 = Extension.builder().firstName("aa").lastName("bb").ext("ab").build();
        List<Extension> extensions = Utils.sortByName(Arrays.asList(extension1, extension2, extension3, extension4));
        Assert.assertEquals("aa", extensions.get(0).getExt());
        Assert.assertEquals("ab", extensions.get(1).getExt());
        Assert.assertEquals("ba", extensions.get(2).getExt());
        Assert.assertEquals("ca", extensions.get(3).getExt());
    }


    @Test
    public void sortByName_firstNameIsSame_lastNameNullOrEmpty() {
        Extension extension1 = Extension.builder().firstName("aa").build();
        Extension extension2 = Extension.builder().firstName("aa").lastName("aa").build();
        Extension extension3 = Extension.builder().firstName("aa").lastName("").build();
        Extension extension4 = Extension.builder().firstName("aa").lastName("ab").build();
        List<Extension> extensions = Utils.sortByName(Arrays.asList(extension1, extension2, extension3, extension4));
        Assert.assertEquals("", extensions.get(0).getLastName());
        Assert.assertEquals("aa", extensions.get(1).getLastName());
        Assert.assertEquals("ab", extensions.get(2).getLastName());
        Assert.assertNull(extensions.get(3).getLastName());
    }

    @Test
    public void sortByName_firstNameIsSame_extNullOrEmpty() {
        Extension extension1 = Extension.builder().firstName("aa").build();
        Extension extension2 = Extension.builder().firstName("aa").ext("aa").build();
        Extension extension3 = Extension.builder().firstName("aa").ext("").build();
        Extension extension4 = Extension.builder().firstName("aa").ext("ab").build();
        List<Extension> extensions = Utils.sortByName(Arrays.asList(extension1, extension2, extension3, extension4));
        Assert.assertEquals("", extensions.get(0).getExt());
        Assert.assertEquals("aa", extensions.get(1).getExt());
        Assert.assertEquals("ab", extensions.get(2).getExt());
        Assert.assertNull(extensions.get(3).getExt());
    }


    @Test
    public void sortByExtType() {
        Extension extension1 = Extension.builder().extType("AO").build();
        Extension extension2 = Extension.builder().extType("User").build();
        Extension extension3 = Extension.builder().extType("Other").build();
        Extension extension4 = Extension.builder().extType("TMO").build();
        Extension extension5 = Extension.builder().extType("Dept").build();
        List<Extension> extensions = Utils.sortByExtType(Arrays.asList(extension1, extension2, extension3, extension4, extension5));
        Assert.assertEquals("User", extensions.get(0).getExtType());
        Assert.assertEquals("Dept", extensions.get(1).getExtType());
        Assert.assertEquals("AO", extensions.get(2).getExtType());
        Assert.assertEquals("TMO", extensions.get(3).getExtType());
        Assert.assertEquals("Other", extensions.get(4).getExtType());
    }

    @Test
    public void sortByExtType_withNullAndNonExistType() {
        Extension extension1 = Extension.builder().extType("AO").build();
        Extension extension2 = Extension.builder().extType("User").build();
        Extension extension3 = Extension.builder().extType("Other").build();
        Extension extension4 = Extension.builder().extType("NonExistsType").build();
        Extension extension5 = Extension.builder().extType("TMO").build();
        Extension extension6 = Extension.builder().build();
        Extension extension7 = Extension.builder().extType("Dept").build();
        List<Extension> extensions = Utils.sortByExtType(Arrays.asList(extension1, extension2, extension3,
                extension4, extension5, extension6, extension7));
        Assert.assertEquals("User", extensions.get(0).getExtType());
        Assert.assertEquals("Dept", extensions.get(1).getExtType());
        Assert.assertEquals("AO", extensions.get(2).getExtType());
        Assert.assertEquals("TMO", extensions.get(3).getExtType());
        Assert.assertEquals("Other", extensions.get(4).getExtType());
        Assert.assertEquals("NonExistsType", extensions.get(5).getExtType());
        Assert.assertNull(extensions.get(6).getExtType());
    }

    @Test
    public void sumByQuarter() {

        List<SaleItem> saleItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            saleItems.add(SaleItem.builder().month(i).saleNumbers(100 * (i + 1)).build());
        }

        List<QuarterSalesItem> quarterSalesItems = Utils.sumByQuarter(saleItems);
        ImmutableMap<Integer, Double> resultMap = ImmutableMap.of(0, 600d, 1, 1500d, 2, 2400d, 3, 3300d);
        for (QuarterSalesItem quarterSalesItem : quarterSalesItems) {
            Assert.assertEquals(resultMap.get(quarterSalesItem.getQuarter()), (Double) quarterSalesItem.getValue());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumByQuarter_boundaryTest() {

        SaleItem saleItem1 = SaleItem.builder().month(0).saleNumbers(Double.MAX_VALUE).build();
        SaleItem saleItem2 = SaleItem.builder().month(1).saleNumbers(Double.MAX_VALUE).build();
        List<SaleItem> saleItems = Arrays.asList(saleItem1, saleItem2);

        List<QuarterSalesItem> quarterSalesItems = Utils.sumByQuarter(saleItems);
    }

    @Test
    public void sumByQuarter_negative() {

        List<SaleItem> saleItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            saleItems.add(SaleItem.builder().month(i).saleNumbers(-100 * (i + 1)).build());
        }

        List<QuarterSalesItem> quarterSalesItems = Utils.sumByQuarter(saleItems);
        ImmutableMap<Integer, Double> resultMap = ImmutableMap.of(0, -600d, 1, -1500d, 2, -2400d, 3, -3300d);
        for (QuarterSalesItem quarterSalesItem : quarterSalesItems) {
            Assert.assertEquals(resultMap.get(quarterSalesItem.getQuarter()), (Double) quarterSalesItem.getValue());
        }
    }

    @Test
    public void maxByQuarter() {
        List<SaleItem> saleItems = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            saleItems.add(SaleItem.builder().month(i).saleNumbers(100 * (i + 1)).build());
        }

        List<QuarterSalesItem> quarterSalesItems = Utils.maxByQuarter(saleItems);
        ImmutableMap<Integer, Double> resultMap = ImmutableMap.of(0, 300d, 1, 600d, 2, 900d, 3, 1200d);
        for (QuarterSalesItem quarterSalesItem : quarterSalesItems) {
            Assert.assertEquals(resultMap.get(quarterSalesItem.getQuarter()), (Double) quarterSalesItem.getValue());
        }
    }


    @Test
    public void getUnUsedKeys() {

        int[] allKeys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] usedKeys = {2, 3, 4};
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeys, usedKeys);
        Assert.assertArrayEquals(unUsedKeys, new int[]{0, 1, 5, 6, 7, 8, 9});

    }

    @Test
    public void getUnUsedKeys_unsort() {

        int[] allKeys = {8, 1, 6, 3, 5, 4, 2, 7, 0, 9};
        int[] usedKeys = {3, 2, 4};
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeys, usedKeys);
        Assert.assertArrayEquals(unUsedKeys, new int[]{0, 1, 5, 6, 7, 8, 9});

    }

    @Test
    public void getUnUsedKeys_duplicateKey() {

        int[] allKeys = {8, 8, 1, 1, 1, 6, 3, 5, 4, 2, 2, 7, 0, 9};
        int[] usedKeys = {3, 3, 2, 4};
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeys, usedKeys);
        Assert.assertArrayEquals(unUsedKeys, new int[]{0, 1, 5, 6, 7, 8, 9});

    }
}