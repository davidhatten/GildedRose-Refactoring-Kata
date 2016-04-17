package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/17/16.
 */
public class ItemClassifierTest {

    private ItemClassifier classifier;

    @Before
    public void setUp() throws Exception {
        classifier = new ItemClassifier();
    }

    @Test
    public void shouldClassifyStandardItem() throws Exception {
        Item item = new Item("food", 10, 10);
        ItemWrapper classifiedItem = classifier.classifyItem(item);

        assertEquals(ItemType.STANDARD, classifiedItem.getType());
    }

    @Test
    public void shouldClassifyNonStandardItems() throws Exception {
        Item brie = new Item("Aged Brie", 10, 10);
        ItemWrapper specialItem = classifier.classifyItem(brie);

        assertEquals(ItemType.SPECIAL, specialItem.getType());

        Item passes = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        ItemWrapper wrappedPasses = classifier.classifyItem(passes);

        assertEquals(ItemType.SPECIAL, wrappedPasses.getType());

        Item sulfras = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        ItemWrapper wrappedSulfras = classifier.classifyItem(sulfras);

        assertEquals(ItemType.SPECIAL, wrappedSulfras.getType());
    }
}