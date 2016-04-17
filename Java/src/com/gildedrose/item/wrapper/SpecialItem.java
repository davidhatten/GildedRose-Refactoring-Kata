package com.gildedrose.item.wrapper;

import com.gildedrose.ConcertTicketUpdater;
import com.gildedrose.item.ItemType;
import com.gildedrose.item.Item;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class SpecialItem extends ItemWrapper {
    private final ConcertTicketUpdater ticketUpdater;

    /*
    This is a placeholder class, I'm not writing a test just for it
    it's getting decomposed into different item classes
     */

    public SpecialItem(Item target) {
        super(target);
        ticketUpdater = new ConcertTicketUpdater();
    }

    @Override
    public ItemType getType() {
        return ItemType.SPECIAL;
    }

    @Override
    public void updateSellIn() {
        item.sellIn--;
    }

    @Override
    protected void updateQuality() {
        if (item.quality < 50) {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                ticketUpdater.updateQuality(item);
            } else {
                item.quality += 1;
            }
        }
    }

    @Override
    protected void ifExpired() {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                item.quality--;
            }
        } else {
            item.quality = 0;
        }
    }
}
