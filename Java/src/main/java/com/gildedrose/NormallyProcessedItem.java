package com.gildedrose;

public class NormallyProcessedItem extends Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public NormallyProcessedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        decreaseQuality(1);
    }

    public void updateSellIn() {
        sellIn -= 1;
    }

    public void decreaseQuality(int decreaseAmount) {
        int calculatedDecreaseAmount = calculateDecreaseAmount(decreaseAmount);

        quality = Math.max(MIN_QUALITY, Math.min(quality - calculatedDecreaseAmount, MAX_QUALITY));
    }

    public void increaseQuality(int increaseAmount) {
        quality = Math.max(MIN_QUALITY, Math.min(quality + increaseAmount, MAX_QUALITY));
    }

    private int calculateDecreaseAmount(int decreaseAmount) {
        if (sellIn < 0) {
            decreaseAmount *= 2;
        }
        return decreaseAmount;
    }

}
