package com.gildedrose;

public class ItemCreator {

    public static Item createItem(String name, int sellIn, int quality) {

        ItemsType itemType = ItemsType.fromString(name);

        switch (itemType) {
            case AGED_BRIE:
                return new AgedItem(name, sellIn, quality);
            case BACKSTAGE_PASSES:
                return new BackstagePassesItem(name, sellIn, quality);
            case SULFURAS:
                return new LegendaryItem(name, sellIn, quality);
            case CONJURED:
                return new ConjuredItem(name, sellIn, quality);
            default:
                return new NormalItem(name, sellIn, quality);
        }
    }

}
