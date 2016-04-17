package com.gildedrose.item.wrapper;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemType;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class Sulfuras extends ItemWrapper {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public ItemType getType() {
        return ItemType.SULFURAS;
    }

    @Override
    protected void updateSellIn() {
        //No-op
    }

    @Override
    protected void updateQuality() {
        //No-op
    }

    @Override
    protected void ifExpired() {
        //No-op
    }
}
