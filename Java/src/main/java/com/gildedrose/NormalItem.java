package com.gildedrose;

import static com.gildedrose.ItemsUtil.updateQualityField;
import static com.gildedrose.ItemsUtil.updateSellInField;

public class NormalItem extends Item {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * The quality of the item decreases by 1 for each decrease in the sellIn value.
     * The minimum quality is 0.
     */
    public void updateQuality() {
        quality = updateQualityField(sellIn, quality, -1);
    }

    /**
     * The sellIn value decreases by 1 each day.
     */
    public void updateSellIn() {
        sellIn = updateSellInField(sellIn);
    }

}
