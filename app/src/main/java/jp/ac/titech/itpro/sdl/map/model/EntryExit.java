package jp.ac.titech.itpro.sdl.map.model;

import java.sql.Time;
import java.util.Map;

public class EntryExit {
    public String name;
    public Time time;

    public EntryExit(String name, Time time) {
        this.name = name;
        this.time = time;
    }
}
