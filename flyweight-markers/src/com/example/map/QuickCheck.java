package com.example.map;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// counts how many unique MarkerStyle objects exist across all markers
// after flyweight, this should be a small number (bounded by style combinations)
public class QuickCheck {

    public static void main(String[] args) {
        int n = 20_000;

        MapDataSource ds = new MapDataSource();
        List<MapMarker> markers = ds.loadMarkers(n);

        Set<Integer> identities = new HashSet<>();
        for (MapMarker m : markers) {
            identities.add(System.identityHashCode(m.getStyle()));
        }

        System.out.println("Markers: " + n);
        System.out.println("Unique style instances (by identity): " + identities.size());
        System.out.println("Expected after Flyweight: <= " + (3 * 4 * 4 * 2) + " (shape*color*size*filled)");
    }
}
