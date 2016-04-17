package com.gildedrose.item.wrapper;

import com.gildedrose.item.ItemType;
import com.gildedrose.item.Item;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public abstract class ItemWrapper {
    protected final Item item;

    ItemWrapper(Item target) {
        item = target;
    }

    public abstract ItemType getType();

    protected abstract void updateSellIn();

    protected abstract void updateQuality();

    protected abstract void ifExpired();

    public void ageOneDay() {
        updateSellIn();

        if (item.quality > 0) {
            updateQuality();
        }

        if (item.sellIn < 0) {
            ifExpired();
        }
    }

    protected void incrementQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
