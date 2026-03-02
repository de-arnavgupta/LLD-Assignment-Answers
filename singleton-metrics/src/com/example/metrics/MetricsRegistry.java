package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// singleton metrics registry using the static holder pattern
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> counters = new HashMap<>();

    // prevents reflection from creating a second instance
    private static boolean created = false;

    private MetricsRegistry() {
        // blow up if someone tries to call the constructor again via reflection
        if (created) {
            throw new IllegalStateException("singleton already exists, use getInstance()");
        }
        created = true;
    }

    // inner class gets loaded lazily by the JVM, so this is thread-safe
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

    // when deserialized, return the existing instance instead of a new one
    @Serial
    private Object readResolve() {
        return getInstance();
    }
}
