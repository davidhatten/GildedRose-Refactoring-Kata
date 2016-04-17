package com.gildedrose;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class StandardItem extends ItemWrapper {

    public StandardItem(Item target) {
        super(target);
    }

    @Override
    public ItemType getType() {
        return ItemType.STANDARD;
    }

    @Override
    protected void updateSellIn() {
        item.sellIn--;
    }

    @Override
    protected void updateQuality() {
        item.quality--;
    }

    @Override
    protected void ifExpired() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
