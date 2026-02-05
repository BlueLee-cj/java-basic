package com.example.lcj.algorithm.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/12/7 15:57
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE = 0;

    public LRUCache(int cacheSize) {
        //supe
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.removeEldestEntry(eldest);
    }
}
