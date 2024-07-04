package com.gildedrose;

public class ConjuredItem extends NormallyProcessedItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Quality decreases 2 times faster
     */
    @Override
    public void updateQuality() {
        decreaseQuality(2);
    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
    }

}
