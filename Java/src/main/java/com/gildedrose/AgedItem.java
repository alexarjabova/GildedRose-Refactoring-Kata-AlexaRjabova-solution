package com.gildedrose;

public class AgedItem extends NormallyProcessedItem {

    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * For items of the AgedItem type, the quality value increases by 1 as the items age.
     * The maximum quality is 50.
     */
    @Override
    public void updateQuality() {
        //todo
        if (quality < 50) {
            increaseQuality(1);
        }
    }

}
