package com.gildedrose;

public class LegendaryItem extends NormallyProcessedItem{

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Quality unchanged and always 80
     */
    @Override
    public void updateQuality() {
    }

    /**
     * SellIn unchanged and always 0
     */
    @Override
    public void updateSellIn() {
    }

}
