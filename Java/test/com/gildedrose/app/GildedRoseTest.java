package com.gildedrose.app;

import static org.junit.Assert.*;

import com.gildedrose.item.Item;
import org.junit.Test;

public class GildedRoseTest {

    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFRAS = "Sulfuras, Hand of Ragnaros";

    /*
    These are now redundant, but i'm keeping them around
    Ideally, the app could be restructured to not take items in it constructor
    But as I understand it, I'm not allowed to do that.
    Also I'm too lazy to get proper dependency management in here
     */

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
    public void agedBrieBehaviorAfterExpire() throws Exception {
        GildedRose app = instantiateAppWithItem("Aged Brie", 0, 10);
        app.updateQuality();
        assertEquals(12, getFirstItemQuality(app));
    }

    @Test
    public void itemQualityCantBeGreaterThan50() throws Exception {
        GildedRose app = instantiateAppWithItem("Aged Brie", 10, 50);
        app.updateQuality();

        assertEquals(50, getFirstItemQuality(app));
    }

    @Test
    public void backstagePassesQualityIsRelativeToSellInDate() {
        GildedRose app = instantiateAppWithItem(BACKSTAGE_PASSES, 11, 10);
        app.updateQuality();

        assertEquals(11, getFirstItemQuality(app));
        app.updateQuality();
        //Value increases by 2 when there are 10 days or less left
        assertEquals(13, getFirstItemQuality(app));

        app = instantiateAppWithItem(BACKSTAGE_PASSES, 5, 10);
        app.updateQuality();
        //Value increase by 3 whene there are 5 days or less left
        assertEquals(13, getFirstItemQuality(app));

        app = instantiateAppWithItem(BACKSTAGE_PASSES, 0, 10);
        app.updateQuality();
        //Value is 0 after the concert
        assertEquals(0, getFirstItemQuality(app));
    }

    @Test
    public void sulfrasNeverDecreasesInValueOrSellinDate() throws Exception {
        GildedRose app = instantiateAppWithItem(SULFRAS, 10, 80);
        app.updateQuality();

        assertEquals(80, getFirstItemQuality(app));
        assertEquals(10, getFirstItemSellIn(app));
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
