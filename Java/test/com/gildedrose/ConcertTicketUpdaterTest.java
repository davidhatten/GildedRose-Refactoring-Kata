package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davidhatten-laptop on 4/15/16.
 */
public class ConcertTicketUpdaterTest {
    @Test
    public void updateQualityWith10Days() throws Exception {
        Item ticket = new Item("name", 10, 10);
        new ConcertTicketUpdater().updateQuality(ticket);

        assertEquals(12, ticket.quality);
    }

    @Test
    public void updateQualityWith5Days() throws Exception {
        Item ticket = new Item("name", 5, 10);
        new ConcertTicketUpdater().updateQuality(ticket);

        assertEquals(13, ticket.quality);
    }
}