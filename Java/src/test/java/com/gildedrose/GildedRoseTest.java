package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @ParameterizedTest
//    @CsvSource({
//            "Aged Brie, 3, 12, 2, 13",
//            "Aged Brie, 10, 50, 9, 50",
//            "Aged Brie, 0, 48, -1, 49"
//    })
//    void testAgedBrieItemQualityUpdate(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
//        Item[] items = new Item[] { ItemCreator.createItem(name, sellIn, quality) };
//        GildedRose app = new GildedRose(items);
//
//        app.updateQuality();
//        assertEquals(name, app.items[0].name);
//        assertEquals(expectedSellIn, app.items[0].sellIn);
//        assertEquals(expectedQuality, app.items[0].quality);
//    }

    @Test
    void testAgedBrieItemQualityUpdate() {
        Item[] items = new Item[] { ItemCreator.createItem("Aged Brie", 3, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void testAgedBrieItemQualityUpdate_whenQualityIsMaxValue() {
        Item[] items = new Item[] { ItemCreator.createItem("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testAgedBrieItemQualityUpdate_whenSellInEqualsZero() {
        Item[] items = new Item[] { ItemCreator.createItem("Aged Brie", 0, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testBackstageItemItemQualityUpdate_whenConcertToday() {
        Item[] items = new Item[] { ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 1, 8) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testBackstageItemItemQualityUpdate_aterConcert_sellInLessThenZero() {
        Item[] items = new Item[] { ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 8) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstageItemQualityUpdate_5daysBeforeConcert() {
        Item[] items = new Item[] { ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 6, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void testBackstageItemQualityUpdate_9daysBeforeConcert() {
        Item[] items = new Item[] { ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void testBackstageItemQualityUpdate_12daysBeforeConcert() {
        Item[] items = new Item[] { ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 13, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(12, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void testLegendaryItemQualityUpdate_qualityAlways80_sellInAlwaysZero() {
        Item[] items = new Item[] { ItemCreator.createItem("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityUpdate() {
        Item[] items = new Item[] { ItemCreator.createItem("Conjured Emberstone", 15, 30) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Conjured Emberstone", app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityUpdate_qualityShouldDrop2timesFasterOnceEventPassed() {
        Item[] items = new Item[] { ItemCreator.createItem("Conjured Emberstone", 0, 26) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Conjured Emberstone", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testUnknownItemQualityUpdate() {
        Item[] items = new Item[] { ItemCreator.createItem("Unknown Item with Default Quality field update process", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Unknown Item with Default Quality field update process", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testUnknownItemQualityUpdate_whenSellInLessThenZero() {
        Item[] items = new Item[] { ItemCreator.createItem("Unknown Item with Default Quality field update process", -3, 3) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("Unknown Item with Default Quality field update process", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "Sulfuras, Hand of Ragnaros; 0; 0; 0; 0",
            "Conjured Emberstone; 7; 0; 6; 0",
            "Unknown Item with Default Quality field update process; 12; 0; 11; 0"
    })
    void testUnknownItemQualityUpdate_qualityCanNotBeNegative(String name, int sellIn, int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { ItemCreator.createItem(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

}
