package com.gildedrose;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
abstract class ItemWrapper {
    protected final Item item;

    ItemWrapper(Item target) {
        item = target;
    }

    public abstract ItemType getType();

    protected abstract void updateSellIn();

    protected abstract void updateQuality();

    protected abstract void ifExpired();

    public void ageOneDay() {
        //Not sure if this one should go here or in the implementations
        //I'm waffling on it, totally open to suggestion
        //It's covered by the GildedRoseTest
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            updateSellIn();
        }

        if (item.quality > 0) {
            updateQuality();
        }

        if (item.sellIn < 0) {
            ifExpired();
        }
    }
}
