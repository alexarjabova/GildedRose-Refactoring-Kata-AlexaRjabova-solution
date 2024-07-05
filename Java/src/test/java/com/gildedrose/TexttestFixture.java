package com.gildedrose;

import static com.gildedrose.ItemConstants.*;

public class TexttestFixture {

    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                ItemCreator.createItem("+5 Dexterity Vest", 10, 20),
                ItemCreator.createItem(AGED_BRIE, 2, 0),
                ItemCreator.createItem("Elixir of the Mongoose", 5, 7),
                ItemCreator.createItem(SULFURAS, 0, 80),
                ItemCreator.createItem(SULFURAS, -1, 80),
                ItemCreator.createItem(BACKSTAGE_PASSES, 15, 20),
                ItemCreator.createItem(BACKSTAGE_PASSES, 10, 49),
                ItemCreator.createItem(BACKSTAGE_PASSES, 5, 49),
                ItemCreator.createItem(CONJURED, 3, 6)
        };

        GildedRose app = new GildedRose(items);

        int days = 2;
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
