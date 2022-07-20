package jp.ac.titech.itpro.sdl.map.model;

import android.util.Log;

import com.google.android.gms.maps.model.Marker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ViewModel implements Model{
    private ArrayList<Place> places;
    private ArrayList<EntryExit> entryExitList;

    public ViewModel() {
        places = new ArrayList<Place>();
        entryExitList = new ArrayList<EntryExit>();
    }

    @Override
    public void registerPlace(Marker marker) {
        places.add(new Place(marker, marker.getTitle()));
    }

    @Override
    public void deletePlace(Marker marker) {
        Iterator<Place> placeIterator = places.iterator();
        while (placeIterator.hasNext()) {
            Place place = placeIterator.next();
            if (place.marker == marker)
                placeIterator.remove();
        }
    }

    @Override
    public void entryPlace(Marker marker, Time time) {
        entryExitList.add(new EntryExit(marker.getTitle(), time));
    }

    @Override
    public void exitPlace(Marker marker, Time time) {
        entryExitList.add(new EntryExit(marker.getTitle(), time));
    }
}
