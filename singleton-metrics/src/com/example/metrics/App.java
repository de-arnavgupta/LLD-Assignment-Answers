package com.example.metrics;

import java.util.Map;

/**
 * PulseMeter CLI entry point.
 */
public class App {

    public static void main(String[] args) throws Exception {
        String propsPath = "metrics.properties";

        MetricsLoader loader = new MetricsLoader();
        MetricsRegistry loaded = loader.loadFromFile(propsPath);

        // both should point to the same object since it's a singleton
        MetricsRegistry global = MetricsRegistry.getInstance();

        System.out.println("Loaded registry instance  : " + System.identityHashCode(loaded));
        System.out.println("Global registry instance  : " + System.identityHashCode(global));

        global.increment("REQUESTS_TOTAL");
        System.out.println("\nREQUESTS_TOTAL = " + global.getCount("REQUESTS_TOTAL"));

        System.out.println("\nAll counters:");
        for (Map.Entry<String, Long> e : global.getAll().entrySet()) {
            System.out.println("  " + e.getKey() + " = " + e.getValue());
        }

        System.out.println("\nTIP: Run ConcurrencyCheck / ReflectionAttack / SerializationCheck for validations.");
    }
}
