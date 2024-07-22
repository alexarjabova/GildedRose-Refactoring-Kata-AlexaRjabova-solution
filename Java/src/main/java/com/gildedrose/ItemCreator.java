package com.gildedrose;

import static com.gildedrose.ItemConstants.*;

public class ItemCreator {

    public static Item createItem(String name, int sellIn, int quality) {

        switch (name) {
            case AGED_BRIE:
                return new AgedItem(name, sellIn, quality);
            case BACKSTAGE_PASSES:
                return new BackstagePassesItem(name, sellIn, quality);
            case SULFURAS:
                return new LegendaryItem(name, sellIn, quality);
            case CONJURED:
                return new ConjuredItem(name, sellIn, quality);
            default:
                return new NormallyProcessedItem(name, sellIn, quality);
        }
    }

}
