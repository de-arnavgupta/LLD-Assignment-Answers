package com.example.map;

// a single marker on the map — style is shared, rest is unique per marker
public class MapMarker {

    private final double lat;
    private final double lng;
    private final String label;
    private final MarkerStyle style; // shared across markers with same look

    public MapMarker(double lat, double lng, String label, MarkerStyle style) {
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.style = style;
    }

    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public String getLabel() { return label; }
    public MarkerStyle getStyle() { return style; }
}
