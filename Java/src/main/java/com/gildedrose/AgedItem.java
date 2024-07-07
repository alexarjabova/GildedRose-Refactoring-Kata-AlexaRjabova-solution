package com.gildedrose;

import static com.gildedrose.ItemsUtil.updateQualityField;

public class AgedItem extends NormalItem {

    public AgedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * For items of the AgedItem type, the quality value increases by 1 as the items age.
     * The maximum quality is 50.
     */
    @Override
    public void updateQuality() {
        quality = updateQualityField(sellIn, quality, 1);
    }

}
