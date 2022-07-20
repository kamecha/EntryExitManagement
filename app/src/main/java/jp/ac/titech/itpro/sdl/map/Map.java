package jp.ac.titech.itpro.sdl.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

import jp.ac.titech.itpro.sdl.map.model.ViewModel;

public class Map extends Fragment implements OnMapReadyCallback {
    private ViewModel viewModel;
    private GoogleMap map;

    public Map(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(tapLocation -> {
            LatLng location = new LatLng(tapLocation.latitude, tapLocation.longitude);
            String str = String.format(Locale.JAPAN, "%f, %f", tapLocation.latitude, tapLocation.longitude);
            Marker marker = this.map.addMarker(new MarkerOptions().position(location).title(str));
            viewModel.registerPlace(marker);
        });
    }
}
