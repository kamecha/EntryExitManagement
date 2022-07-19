package jp.ac.titech.itpro.sdl.map.model;

import com.google.android.gms.maps.model.Marker;

import java.sql.Time;

public interface Model {
    // 場所の登録
    void registerPlace(Marker marker);
    // 場所の削除
    void deletePlace(Marker marker);
    // 場所への入出の登録
    void entryPlace(Marker marker, Time time);
    // 場所からの退出の登録
    void exitPlace(Marker marker, Time time);
}
