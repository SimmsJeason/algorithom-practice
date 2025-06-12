package javaBase.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 <K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache2() {
        super(MAX_ENTRIES, 0.75f, true);
    }
}

