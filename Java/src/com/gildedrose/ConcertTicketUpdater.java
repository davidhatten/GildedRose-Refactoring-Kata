package com.gildedrose;

/**
 * Created by davidhatten-laptop on 4/15/16.
 */
public class ConcertTicketUpdater {
    public void updateQuality(Item item) {
        if (item.sellIn < 6) {
            item.quality += 3;
        } else if (item.sellIn < 11) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
    }
}
