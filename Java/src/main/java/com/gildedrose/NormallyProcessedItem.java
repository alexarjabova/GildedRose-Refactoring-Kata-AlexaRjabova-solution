package com.gildedrose;

import static com.gildedrose.ItemConstants.MAX_QUALITY;
import static com.gildedrose.ItemConstants.MIN_QUALITY;

public class NormallyProcessedItem extends Item {

    public NormallyProcessedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * The quality of the item decreases by 1 for each decrease in the sellIn value.
     * The minimum quality is 0.
     */
    public void updateQuality() {
        decreaseQuality(1);
    }

    /**
     * The sellIn value decreases by 1 each day.
     */
    public void updateSellIn() {
        sellIn -= 1;
    }

    public void decreaseQuality(int decreaseAmount) {
        int calculatedDecreaseAmount = calculateDecreaseIncreaseAmount(decreaseAmount);

        quality = Math.max(MIN_QUALITY, Math.min(quality - calculatedDecreaseAmount, MAX_QUALITY));
    }

    public void increaseQuality(int increaseAmount) {
        int calculatedIncreaseAmount = calculateDecreaseIncreaseAmount(increaseAmount);

        quality = Math.max(MIN_QUALITY, Math.min(quality + calculatedIncreaseAmount, MAX_QUALITY));
    }

    private int calculateDecreaseIncreaseAmount(int decreaseAmount) {
        if (sellIn < 0) {
            decreaseAmount *= 2;
        }
        return decreaseAmount;
    }

}
