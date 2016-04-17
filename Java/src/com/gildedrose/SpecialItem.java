package com.gildedrose;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class SpecialItem implements ItemWrapper {

    private final Item item;

    public SpecialItem(Item target) {
        item = target;
    }

    @Override
    public ItemType getType() {
        return ItemType.SPECIAL;
    }
}
