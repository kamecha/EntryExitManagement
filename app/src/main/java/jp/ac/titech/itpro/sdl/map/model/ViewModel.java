package jp.ac.titech.itpro.sdl.map.model;

import android.util.Log;

import com.google.android.gms.maps.model.Marker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class ViewModel implements Model{
    public ArrayList<Place> places;
    public ArrayList<EntryExit> entryExitList;

    public ViewModel() {
        places = new ArrayList<Place>();
        entryExitList = new ArrayList<EntryExit>();
        entryExitList.add(new EntryExit("サンプル", new Date(), EntryExit.EntryOrExit.ENTRY));
        entryExitList.add(new EntryExit("サンプル", new Date(), EntryExit.EntryOrExit.EXIT));
        entryExitList.add(new EntryExit("およよ", new Date(), EntryExit.EntryOrExit.ENTRY));
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
        entryExitList.add(new EntryExit(marker.getTitle(), time, EntryExit.EntryOrExit.ENTRY));
    }

    @Override
    public void exitPlace(Marker marker, Time time) {
        entryExitList.add(new EntryExit(marker.getTitle(), time, EntryExit.EntryOrExit.ENTRY));
    }
}
