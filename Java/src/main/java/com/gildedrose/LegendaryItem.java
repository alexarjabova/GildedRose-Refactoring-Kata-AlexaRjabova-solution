package com.gildedrose;

public class LegendaryItem extends NormalItem {

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * The quality of the item remains unchanged and is always set to 80.
     */
    @Override
    public void updateQuality() {
    }

    /**
     * The sellIn value remains unchanged and is always set to 0.
     */
    @Override
    public void updateSellIn() {
    }

}
