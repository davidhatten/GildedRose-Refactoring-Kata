package com.gildedrose.item.wrapper;

import com.gildedrose.item.Item;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/19/16.
 */
public class SulfurasTest {

    @Test
    public void itShouldNotChangeAtAll() throws Exception {
        Item item = new Item(Sulfuras.ITEM_NAME, 10, 80);
        Sulfuras sulfuras = new Sulfuras(item);

        sulfuras.ageOneDay();
        
        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }
}