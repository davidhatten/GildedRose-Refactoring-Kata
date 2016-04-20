package com.gildedrose.item.wrapper;

import com.gildedrose.BackstagePassesQualityUpdater;
import com.gildedrose.item.Item;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/19/16.
 */
public class BackstagePassesTest {

    @Test @Ignore("Don't look behind the curtain")
    public void itShouldUseQualityUpdater() throws Exception {
        //I don't feel like getting mockito or spock in here
        //pretend this mocks the quality updater and makes sure it's called
        //So instead, see the below test
    }

    @Test
    public void itShouldIncreaseQualityRelatedToSellIn() throws Exception {
        Item item = new Item(BackstagePasses.ITEM_NAME, 11, 10);
        BackstagePasses backstagePasses = new BackstagePasses(item);

        backstagePasses.ageOneDay();
        assertEquals(11, item.quality);
        assertEquals(10, item.sellIn);

        //Value increases by 2 when there are 10 days or less left
        backstagePasses.ageOneDay();
        assertEquals(13, item.quality);

        item = new Item(BackstagePasses.ITEM_NAME, 5, 10);
        backstagePasses = new BackstagePasses(item);

        //Value increase by 3 whene there are 5 days or less left
        backstagePasses.ageOneDay();
        assertEquals(13, item.quality);
    }

    @Test
    public void itShouldHaveNoQualityAfterItExpires() throws Exception {
        Item item = new Item(BackstagePasses.ITEM_NAME, 0, 100);
        BackstagePasses backstagePasses = new BackstagePasses(item);

        backstagePasses.ageOneDay();

        assertEquals(0, item.quality);

    }
}