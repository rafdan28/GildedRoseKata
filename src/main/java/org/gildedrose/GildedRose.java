package org.gildedrose;

public class GildedRose {
    Item[] items;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!checkNameEqualAgeBrie(i) && !checkNameEqualPassConcert(i)) {
                checkQualityGreaterThan0(i);
            } else {
                checkQualityLessThan50(i);
            }

            if (!checkNameEqualSulfuras(i)) {
                decrementSellInBy1(i);
            }

            if(checkNameEqualConjured(i)){
                decrementQualityBy2(i);
            }

            checkSellInLessThan0(i);
        }
    }

    private void checkQualityLessThan50(int i) {
        if (items[i].quality < 50) {
            incrementQualityBy1(i);

            if (checkNameEqualPassConcert(i)) {
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
            if (!checkNameEqualAgeBrie(i)) {
                if (!checkNameEqualPassConcert(i)) {
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

    private boolean checkNameEqualConjured(int i){
        return (items[i].name.equals("Conjured"));
    }

    private boolean checkNameEqualAgeBrie(int i){
        return (items[i].name.equals("Aged Brie"));
    }

    private boolean checkNameEqualSulfuras(int i){
        return (items[i].name.equals("Sulfuras, Hand of Ragnaros"));
    }

    private boolean checkNameEqualPassConcert(int i){
        return (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"));
    }

    private void checkQualityGreaterThan0(int i) {
        if (items[i].quality > 0) {
            if (!checkNameEqualSulfuras(i) && !checkNameEqualConjured(i)) {
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