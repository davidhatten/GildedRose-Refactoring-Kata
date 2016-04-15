package com.gildedrose;

import static com.gildedrose.GildedRose.SPECIAL_ITEMS;

/**
 * Created by davidhatten-laptop on 4/15/16.
 */
public class QualityUpdater {

    private ConcertTicketUpdater ticketUpdater;

    public QualityUpdater() {
        this(new ConcertTicketUpdater());
    }

    public QualityUpdater(ConcertTicketUpdater concertTicketUpdater) {
        ticketUpdater = concertTicketUpdater;
    }

    public void updateQuality(Item item) {
        if (shouldDecrementQuality(item)) {
            item.quality -= 1;
        } else {
            if (item.quality < 50) {
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    ticketUpdater.updateQuality(item);
                } else {
                    item.quality += 1;
                }
            }
        }
    }

    private boolean shouldDecrementQuality(Item item) {
        if (!SPECIAL_ITEMS.contains(item.name) && item.quality > 0) {
            return true;
        }

        return false;
    }
}
