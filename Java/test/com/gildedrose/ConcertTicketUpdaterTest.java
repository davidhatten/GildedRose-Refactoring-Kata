package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/15/16.
 */
public class ConcertTicketUpdaterTest {
    @Test
    public void updateQualityWith10Days() throws Exception {
        //This is weird. When this utility is being used, sellIn has already been decremented
        //So really, this is the 10th day
        Item ticket = new Item("name", 9, 10);
        new ConcertTicketUpdater().updateQuality(ticket);

        assertEquals(12, ticket.quality);
    }

    @Test
    public void updateQualityWith5Days() throws Exception {
        //Likewise, this is the fourth day
        Item ticket = new Item("name", 4, 10);
        new ConcertTicketUpdater().updateQuality(ticket);

        assertEquals(13, ticket.quality);
    }
}