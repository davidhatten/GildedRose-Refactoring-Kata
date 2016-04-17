package com.gildedrose.app;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemClassifier;
import com.gildedrose.item.wrapper.ItemWrapper;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;
    private ItemClassifier classifier;

    public static List<String> SPECIAL_ITEMS = new ArrayList<String>() {{
        add("Sulfuras, Hand of Ragnaros");
        add("Backstage passes to a TAFKAL80ETC concert");
        add("Aged Brie");
    }};

    public GildedRose(Item[] items) {
        this(items, new ItemClassifier());
    }

    //testing constructor. Don't really have to use yet...
    public GildedRose(Item[] items, ItemClassifier itemClassifier) {
        this.items = items;
        classifier = itemClassifier;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemWrapper item = classifier.classifyItem(items[i]);

            item.ageOneDay();
        }
    }
}

