package com.example.map;

// each marker stores only its own unique data (lat, lng, label)
// the style is a shared reference obtained from MarkerStyleFactory
public class MapMarker {

    private final double lat;
    private final double lng;
    private final String label;
    private final MarkerStyle style;  // shared flyweight, not owned by this marker

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
