package com.example.map;

import java.util.HashMap;
import java.util.Map;

// caches MarkerStyle instances so identical styles are reused instead of duplicated
// this is the core of the flyweight pattern
public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> cache = new HashMap<>();

    public MarkerStyle get(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");

        // reuse existing style if we've seen this combination before
        MarkerStyle existing = cache.get(key);
        if (existing != null) {
            return existing;
        }

        MarkerStyle fresh = new MarkerStyle(shape, color, size, filled);
        cache.put(key, fresh);
        return fresh;
    }

    public int cacheSize() {
        return cache.size();
    }
}
