package com.uwich.interactivemap.building;

// Interface to retrieve a building's id, name, lat and long attributes only
public interface BuildingSummary {
    Integer getId();
    String getName();
    Double getLatitude();
    Double getLongitude();
}
