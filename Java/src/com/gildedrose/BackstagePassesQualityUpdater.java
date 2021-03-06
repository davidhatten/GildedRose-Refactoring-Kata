package com.gildedrose;

import com.gildedrose.item.Item;

/**
 * Created by davidhatten-laptop on 4/15/16.
 */
public class BackstagePassesQualityUpdater {
    public void updateQuality(Item item) {
        if (item.sellIn < 5) {
            item.quality += 3;
        } else if (item.sellIn < 10) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
    }
}
