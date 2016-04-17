package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class StandardItemTest {

    @Test
    public void standardItemShouldDecreaseSellIn() throws Exception {
        Item item = new Item("food", 10, 10);
        StandardItem standardItem = new StandardItem(item);

        standardItem.ageOneDay();

        //Gross, indirection, unintended side effects
        //But I can't modify item, so I can force it to use methods
        //So I can't mock :(
        assertEquals(9, item.sellIn);
    }

    @Test
    public void standardItemShouldDecreaseQualityInRelationToSellIn() throws Exception {
        Item item = new Item("food", 1, 3);
        StandardItem standardItem = new StandardItem(item);

        standardItem.ageOneDay();

        assertEquals(2, item.quality);

        standardItem.ageOneDay();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);

        standardItem.ageOneDay();
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
}