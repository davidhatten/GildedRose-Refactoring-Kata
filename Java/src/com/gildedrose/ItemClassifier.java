package com.gildedrose;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class ItemClassifier {
    public ItemWrapper classifyItem(Item item) {
        ItemWrapper result;

        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                result = new SpecialItem(item);
                break;

            case "Aged Brie":
                result = new SpecialItem(item);
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                result = new SpecialItem(item);
                break;

            default:
                result = new StandardItem(item);
                break;
        }

        return result;
    }
}
