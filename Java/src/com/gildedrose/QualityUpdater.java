package com.gildedrose;

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


    public void updateQualityBeforeSellInDecay(Item item) {
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality -= 1;
                }
            }
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
}
