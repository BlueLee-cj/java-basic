package com.example.lcj.collections.ComparableAndComparator;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/8 22:51
 */
public class SearchResult implements Comparable<SearchResult> {
    int relativeRatio;
    long count;
    int recentOrders;

    public SearchResult(int relativeRatio, long count){
        this.relativeRatio = relativeRatio;
        this.count = count;
    }
    @Override
    public int compareTo(SearchResult o) {
        if (this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }
        if (this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }
        return 0;
    }

    public void setRecentOrders(int recentOrders){
        this.recentOrders = recentOrders;
    }
}
