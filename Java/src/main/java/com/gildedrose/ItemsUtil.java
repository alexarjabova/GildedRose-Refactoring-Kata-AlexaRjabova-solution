package com.gildedrose;

public class ItemsUtil {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    private ItemsUtil() {}

    public static int updateQualityField(int sellIn, int quality, int increment) {
        int calculatedIncrement  = calculateIncrementValue(sellIn, increment);
        return Math.max(MIN_QUALITY, Math.min(quality + calculatedIncrement, MAX_QUALITY));
    }

    public static int updateSellInField(int sellIn) {
        return sellIn - 1;
    }

    private static int calculateIncrementValue(int sellIn, int increment) {
        if (sellIn < 0) {
            return increment * 2;
        }

        return increment;
    }

}
