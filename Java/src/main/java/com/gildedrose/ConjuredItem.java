package com.gildedrose;

public class ConjuredItem extends NormallyProcessedItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * The quality of the item decreases at twice the normal rate.
     */
    @Override
    public void updateQuality() {
        decreaseQuality(2);
    }

    /**
     * The sellIn value decreases by 1 each day
     */
    @Override
    public void updateSellIn() {
        super.updateSellIn();
    }

}
