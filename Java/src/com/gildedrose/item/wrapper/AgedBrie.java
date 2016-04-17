package com.gildedrose.item.wrapper;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemType;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class AgedBrie extends ItemWrapper {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public ItemType getType() {
        return ItemType.AGED_BRIE;
    }

    @Override
    protected void updateSellIn() {
        item.sellIn--;
    }

    @Override
    protected void updateQuality() {
        incrementQuality();
    }

    @Override
    protected void ifExpired() {
        incrementQuality();
    }
}
