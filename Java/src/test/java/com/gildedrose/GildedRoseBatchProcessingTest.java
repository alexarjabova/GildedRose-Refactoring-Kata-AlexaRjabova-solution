package com.gildedrose;

public class GildedRoseBatchProcessingTest {

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                ItemCreator.createItem("+5 Dexterity Vest", 10, 20),
                ItemCreator.createItem("Aged Brie", 2, 0),
                ItemCreator.createItem("Aged Brie", 2, 49),
                ItemCreator.createItem("Elixir of the Mongoose", 5, 7),
                ItemCreator.createItem("Sulfuras, Hand of Ragnaros", 0, 80),
                ItemCreator.createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                ItemCreator.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                ItemCreator.createItem("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        int days = 4;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
