package com.epam.talab.utils;

import java.util.Comparator;

import com.epam.talab.model.coffeepack.Pack;

public class SortByRatio implements Comparator<Pack> {
    public int compare(Pack o1, Pack o2) {
        return ((Double) o2.priceToWeightRatio()).compareTo(o1.priceToWeightRatio());
    }


}