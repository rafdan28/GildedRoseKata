import org.gildedrose.GildedRose;
import org.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    @Test
    void testUpdateQualityOnAgedBrie() {
        Item[] item = { new Item("Aged Brie", 10, 20)};
        GildedRose gr = new GildedRose(item);

        gr.updateQuality();

        assertEquals(gr.getItems()[0].sellIn, 9);
        assertEquals(gr.getItems()[0].quality, 21);
    }

    @Test
    void testUpdateQualityOnConjured() {
        Item[] item = { new Item("Conjured", 10, 20)};
        GildedRose gr = new GildedRose(item);

        gr.updateQuality();

        assertEquals(gr.getItems()[0].sellIn, 9);
        assertEquals(gr.getItems()[0].quality, 18);
    }
}
