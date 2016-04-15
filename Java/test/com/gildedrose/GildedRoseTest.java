package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app =  new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void itShouldDecreaseItemByQualityPerDay() throws Exception {
        GildedRose app = instantiateAppWithItem("food", 10, 5);
        app.updateQuality();

        assertEquals(4, getFirstItemQuality(app));
        assertEquals(9, getFirstItemSellIn(app));
    }

    @Test
    public void itShouldDecreateItemQualityByDoubleAfterExpire() throws Exception {
        GildedRose app = instantiateAppWithItem("food", 0, 6);
        app.updateQuality();

        assertEquals(4, getFirstItemQuality(app));
        assertEquals(-1, getFirstItemSellIn(app));
    }

    @Test
    public void qualityCannotBeNegative() throws Exception {
        GildedRose app = instantiateAppWithItem("food", 0, 0);
        app.updateQuality();

        assertEquals(0, getFirstItemQuality(app));
    }

    @Test
    public void agedBrieIncreasesInQualityWithAge() throws Exception {
        GildedRose app = instantiateAppWithItem("Aged Brie", 10, 10);
        app.updateQuality();

        assertEquals(11, getFirstItemQuality(app));
        assertEquals(9, getFirstItemSellIn(app));
    }

    @Test
    public void itemQualityCantBeGreaterThan50() throws Exception {
        GildedRose app = instantiateAppWithItem("Aged Brie", 10, 50);
        app.updateQuality();

        assertEquals(50, getFirstItemQuality(app));
    }

    @Test
    public void backstagePassesQualityIsRelativeToSellInDate() {
        instantiateAppWithItem(BACKSTAGE_PASSES, 11, 10);
    }

    private int getFirstItemSellIn(GildedRose app) {
        return app.items[0].sellIn;
    }

    private int getFirstItemQuality(GildedRose app) {
        return app.items[0].quality;
    }


    private GildedRose instantiateAppWithItem(String name, int expire, int quality) {
        Item[] items = new Item[]{new Item(name, expire, quality)};
        return new GildedRose(items);
    }


}
