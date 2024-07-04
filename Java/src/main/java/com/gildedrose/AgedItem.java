package com.gildedrose;

public class AgedItem extends NormallyProcessedItem {

    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Items of AgedItem type -> quality value increases the older items gets
     */
    @Override
    public void updateQuality() {
        if (quality < 50) {
            increaseQuality(1);
        }
    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
    }

}
