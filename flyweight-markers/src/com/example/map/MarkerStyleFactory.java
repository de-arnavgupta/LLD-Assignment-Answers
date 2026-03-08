package com.example.map;

import java.util.HashMap;
import java.util.Map;

// keeps a cache of styles so we don't make a new one every time
public class MarkerStyleFactory {

    private final Map<String, MarkerStyle> cache = new HashMap<>();

    public MarkerStyle get(String shape, String color, int size, boolean filled) {
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");

        // already seen this combo? just return it
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
