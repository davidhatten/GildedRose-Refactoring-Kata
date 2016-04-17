package com.gildedrose;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class StandardItem implements ItemWrapper {

    private final Item item;

    public StandardItem(Item target) {
        item = target;
    }

    @Override
    public ItemType getType() {
        return ItemType.STANDARD;
    }
}
