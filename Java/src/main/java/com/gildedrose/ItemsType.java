package com.gildedrose;

public enum ItemsType {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake"),
    NORMAL("Normally ProcessedItem");

    String value;

    ItemsType(String name) {
        this.value = name;
    }

    public String getName() {
        return value;
    }

    public static ItemsType fromString(String name) {
        for (ItemsType itemType : ItemsType.values()) {
            if (itemType.getName().equals(name)) {
                return itemType;
            }
        }
        return NORMAL; // Default type for unrecognized names
    }

}
