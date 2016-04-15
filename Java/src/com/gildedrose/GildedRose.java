package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    private QualityUpdater qualityUpdater;

    public static List<String> SPECIAL_ITEMS = new ArrayList<String>() {{
        add("Sulfuras, Hand of Ragnaros");
        add("Backstage passes to a TAFKAL80ETC concert");
        add("Aged Brie");
    }};

    public GildedRose(Item[] items) {
        this(items, new QualityUpdater());
    }

    public GildedRose(Item[] items, QualityUpdater itemQualityUpdater) {
        this.items = items;
        qualityUpdater = itemQualityUpdater;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!getItemName(i).equals("Sulfuras, Hand of Ragnaros")) {
                decrementItemSellIn(i);
            }
            //initial change in quality
            qualityUpdater.updateQuality(items[i]);

            //Processing any negative sellIn results
            if (getItemSellIn(i) < 0) {
                if (!getItemName(i).equals("Aged Brie")) {
                    if (!getItemName(i).equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (getItemQuality(i) > 0) {
                            if (!getItemName(i).equals("Sulfuras, Hand of Ragnaros")) {
                                decrementItemQuality(i);
                            }
                        }
                    } else {
                        clearItemQuality(i);
                    }
                } else
                    if (getItemQuality(i) < 50 ) {
                        incrementItemQuality(i);
                    }

            }


        }
    }

    private void decrementItemSellIn(int index) {
        items[index].sellIn = getItemSellIn(index) - 1;
    }

    private int getItemSellIn(int index) {
        return items[index].sellIn;
    }

    private void incrementItemQuality(int index) {
        items[index].quality = getItemQuality(index) + 1;
    }

    private void decrementItemQuality(int index) {
        items[index].quality = getItemQuality(index) - 1;
    }

    private int getItemQuality(int index) {
        return items[index].quality;
    }

    private String getItemName(int index) {
        return items[index].name;
    }

    private void clearItemQuality(int index) {
        items[index].quality = 0;
    }
}
