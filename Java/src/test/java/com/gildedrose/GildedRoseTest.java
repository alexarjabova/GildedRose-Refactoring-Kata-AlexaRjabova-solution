package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.gildedrose.ItemsType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testAgedBrieItemQualityUpdate() {
        Item[] items = new Item[] { ItemCreator.createItem(AGED_BRIE.getName(), 3, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(AGED_BRIE.getName(), app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void testAgedBrieItemQualityUpdate_whenQualityIsMaxValue() {
        Item[] items = new Item[] { ItemCreator.createItem(AGED_BRIE.getName(), 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(AGED_BRIE.getName(), app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testAgedBrieItemQualityUpdate_whenSellInEqualsZero() {
        Item[] items = new Item[] { ItemCreator.createItem(AGED_BRIE.getName(), 0, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(AGED_BRIE.getName(), app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackstageItemItemQualityUpdate_whenConcertToday() {
        Item[] items = new Item[] { ItemCreator.createItem(BACKSTAGE_PASSES.getName(), 1, 8) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void testBackstageItemItemQualityUpdate_afterConcert_sellInLessThenZero() {
        Item[] items = new Item[] { ItemCreator.createItem(BACKSTAGE_PASSES.getName(), 0, 8) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstageItemQualityUpdate_5daysBeforeConcert() {
        Item[] items = new Item[] { ItemCreator.createItem(BACKSTAGE_PASSES.getName(), 6, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testBackstageItemQualityUpdate_9daysBeforeConcert() {
        Item[] items = new Item[] { ItemCreator.createItem(BACKSTAGE_PASSES.getName(), 10, 12) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void testBackstageItemQualityUpdate_12daysBeforeConcert() {
        Item[] items = new Item[] { ItemCreator.createItem(BACKSTAGE_PASSES.getName(), 13, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES.getName(), app.items[0].name);
        assertEquals(12, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void testLegendaryItemQualityUpdate_qualityAlways80_sellInAlwaysZero() {
        Item[] items = new Item[] { ItemCreator.createItem(SULFURAS.getName(), 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(SULFURAS.getName(), app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityUpdate() {
        Item[] items = new Item[] { ItemCreator.createItem(CONJURED.getName(), 15, 30) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(CONJURED.getName(), app.items[0].name);
        assertEquals(14, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void testConjuredItemQualityUpdate_qualityShouldDrop2timesFasterOnceEventPassed() {
        Item[] items = new Item[] { ItemCreator.createItem(CONJURED.getName(), 0, 26) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(CONJURED.getName(), app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void testUnknownItemQualityUpdate() {
        Item[] items = new Item[] { ItemCreator.createItem(NORMAL.getName(), 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(NORMAL.getName(), app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void testUnknownItemQualityUpdate_whenSellInLessThenZero() {
        Item[] items = new Item[] { ItemCreator.createItem(NORMAL.getName(), -3, 3) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(NORMAL.getName(), app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "Sulfuras, Hand of Ragnaros; 0; 0; 0; 0",
            "Conjured Mana Cake; 7; 0; 6; 0",
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
