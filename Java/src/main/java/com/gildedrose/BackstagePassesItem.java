package com.gildedrose;

import static com.gildedrose.ItemConstants.MIN_QUALITY;

public class BackstagePassesItem extends NormallyProcessedItem {

    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * The quality of the item increases as the sellIn date approaches.
     * Specifically:
     * The quality increases by 2 if there are between 10 and 5 days remaining until the concert;
     * The quality increases by 3 if there are 5 or fewer days remaining until the concert;
     * Once the concert has passed (sellIn = 0), the quality of the item drops to 0.
     */
    @Override
    public void updateQuality() {
        if (sellIn < 0) {
            quality = MIN_QUALITY;
        } else if (sellIn < 5) {
            increaseQuality(3);
        } else if (sellIn < 10) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
    }

}
