package com.gildedrose;

import static com.gildedrose.ItemsUtil.updateQualityField;

public class ConjuredItem extends NormalItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * The quality of the item decreases at twice the normal rate.
     */
    @Override
    public void updateQuality() {
        quality = updateQualityField(sellIn, quality, -2);
    }

}
