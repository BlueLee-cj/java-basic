package com.example.lcj.collections.ComparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

public class SearchResultComparator implements Comparator<SearchResult> {

    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        if (o1.relativeRatio != o2.relativeRatio) {
            return o1.relativeRatio > o2.relativeRatio ? 1 : -1;
        }
        if (o1.recentOrders != o2.recentOrders) {
            return o1.recentOrders > o2.recentOrders ? 1 : -1;
        }
        if (o1.count != o2.count) {
            return o1.count > o2.count ? 1 : -1;
        }
        return 0;
    }
}