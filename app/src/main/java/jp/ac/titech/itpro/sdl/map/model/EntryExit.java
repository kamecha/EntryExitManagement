package jp.ac.titech.itpro.sdl.map.model;

import java.util.Date;


public class EntryExit {
    public String name;
    public Date time;
    public enum EntryOrExit {
        ENTRY,
        EXIT
    };
    public EntryOrExit entoryOrExit;

    public EntryExit(String name, Date time, EntryOrExit type) {
        this.name = name;
        this.time = time;
        this.entoryOrExit = type;
    }
}
