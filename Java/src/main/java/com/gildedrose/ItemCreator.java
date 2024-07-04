package com.gildedrose;

public class ItemCreator {

    public static Item createItem(String name, int sellIn, int quality) {

        switch (name) {
            case "Aged Brie":
                return new AgedItem(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageItem(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(name, sellIn, quality);
            case "Conjured Mana Cake":
                return new ConjuredItem(name, sellIn, quality);
            default:
                return new NormallyProcessedItem(name, sellIn, quality);
        }
    }

}
