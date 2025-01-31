package com.uwich.interactivemap.geojson;

import lombok.Data;

import java.util.List;

@Data
public class GeoJSON {
    private String type;
    private Data data;

    @lombok.Data
    static class Data {
        private String type;
        private Geometry geometry;
    }

    @lombok.Data
    static class Geometry{
        private String type;
        private List<List<List<Double>>> coordinates;
    }
}
