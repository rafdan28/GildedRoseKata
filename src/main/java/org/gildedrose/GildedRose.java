package org.gildedrose;

public class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    Item[] items;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrie(i) && !isBackstagePasses(i)) {
                checkQualityGreaterThan0(i);
            } else {
                checkQualityLessThan50(i);
            }

            if (!isSulfuras(i)) {
                decrementSellInBy1(i);
            }

            if(isConjured(i)){
                decrementQualityBy2(i);
            }

            checkSellInLessThan0(i);
        }
    }

    private void checkQualityLessThan50(int i) {
        if (items[i].quality < 50) {
            incrementQualityBy1(i);

            if (isBackstagePasses(i)) {
                checksellInLessThan11(i);

                checksellInLessThan6(i);
            }
        }
    }

    private void checksellInLessThan6(int i) {
        if (items[i].sellIn < 6) {
            if (items[i].quality < 50) {
                incrementQualityBy1(i);
            }
        }
    }

    private void checksellInLessThan11(int i) {
        if (items[i].sellIn < 11) {
            if (items[i].quality < 50) {
                incrementQualityBy1(i);
            }
        }
    }

    private void checkSellInLessThan0(int i) {
        if (items[i].sellIn < 0) {
            if (!isAgedBrie(i)) {
                if (!isBackstagePasses(i)) {
                    checkQualityGreaterThan0(i);
                } else {
                    items[i].quality = items[i].quality - items[i].quality;
                }
            } else {
                if (items[i].quality < 50) {
                    incrementQualityBy1(i);
                }
            }
        }
    }

    private boolean isAgedBrie(int i) {
        return AGED_BRIE.equals(items[i].name);
    }

    private boolean isBackstagePasses(int i) {
        return BACKSTAGE_PASSES.equals(items[i].name);
    }

    private boolean isSulfuras(int i) {
        return SULFURAS.equals(items[i].name);
    }

    private boolean isConjured(int i) {
        return CONJURED.equals(items[i].name);
    }

    private void checkQualityGreaterThan0(int i) {
        if (items[i].quality > 0) {
            if (!isSulfuras(i) && !isConjured(i)) {
                decrementQualityBy1(i);
            }
        }
    }

    private void decrementSellInBy1(int i) {
        items[i].sellIn = items[i].sellIn - 1;
    }

    private void decrementQualityBy2(int i) {
        items[i].quality = items[i].quality - 2;
    }

    private void decrementQualityBy1(int i) {
        items[i].quality = items[i].quality - 1;
    }

    private void incrementQualityBy1(int i) {
        items[i].quality = items[i].quality + 1;
    }
}