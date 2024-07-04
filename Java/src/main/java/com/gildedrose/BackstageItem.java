package com.gildedrose;

public class BackstageItem extends NormallyProcessedItem {

    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Quality increases as sellIn approaches
     * Quality + 2 if 10-5 days before concert
     * Quality + 3 if 5 or fewer days before concert
     * After concert (sellIn = 0) -> Quality = 0
     */
    @Override
    public void updateQuality() {
        if (sellIn < 0) {
            quality = MIN_QUALITY;
        } else if (sellIn <= 5) {
            increaseQuality(3);
        } else if (this.sellIn <= 10) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
    }

}
