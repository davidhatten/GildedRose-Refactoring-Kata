package com.gildedrose.item.wrapper;

import com.gildedrose.BackstagePassesQualityUpdater;
import com.gildedrose.item.Item;
import com.gildedrose.item.ItemType;

/**
 * Created by davidhatten-laptop on 4/19/16.
 */
public class BackstagePasses extends ItemWrapper {

    private BackstagePassesQualityUpdater qualityUpdater;
    public static String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(Item item) {
        super(item);
        qualityUpdater = new BackstagePassesQualityUpdater();
    }

    @Override
    public ItemType getType() {
        return ItemType.BACKSTAGE_PASSES;
    }

    @Override
    protected void updateSellIn() {
        item.sellIn--;
    }

    @Override
    protected void updateQuality() {
        qualityUpdater.updateQuality(item);
    }

    @Override
    protected void ifExpired() {
        item.quality = 0;
    }
}
