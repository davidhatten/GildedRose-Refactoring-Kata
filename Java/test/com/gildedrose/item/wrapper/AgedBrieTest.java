package com.gildedrose.item.wrapper;

import com.gildedrose.item.Item;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class AgedBrieTest {

    @Test
    public void itShouldIncreaseInQualityWithAge() throws Exception {
        Item item = new Item("Aged Brie", 10, 10);
        AgedBrie agedBrie = new AgedBrie(item);

        agedBrie.ageOneDay();

        assertEquals(11, item.quality);
        assertEquals(9, item.sellIn);
    }

    @Test
    public void itShouldDoubleIncreaseInQualityWhenExpired() throws Exception {
        Item item = new Item("Aged Brie", 0, 10);
        AgedBrie agedBrie = new AgedBrie(item);

        agedBrie.ageOneDay();

        assertEquals(12, item.quality);
    }
}