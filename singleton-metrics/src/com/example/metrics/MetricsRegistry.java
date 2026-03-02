package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// proper lazy thread-safe singleton using static holder idiom
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> counters = new HashMap<>();

    // flag to block reflection from creating a second instance
    private static boolean created = false;

    private MetricsRegistry() {
        // if someone tries reflection after the instance already exists, blow up
        if (created) {
            throw new IllegalStateException("Use getInstance() — don't try to create another one");
        }
        created = true;
    }

    // holder class is only loaded when getInstance() is first called (lazy + thread-safe)
    private static class Holder {
        static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // deserialization returns the existing singleton, not a new object
    @Serial
    private Object readResolve() {
        return getInstance();
    }
}
