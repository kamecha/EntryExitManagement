package jp.ac.titech.itpro.sdl.map.model;

import com.google.android.gms.maps.model.Marker;

public class Place {
    public Marker marker;
    public String name;

    public Place(Marker marker, String name) {
        this.marker = marker;
        this.name = name;
    }
}
