package jp.ac.titech.itpro.sdl.map;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import jp.ac.titech.itpro.sdl.map.model.ViewModel;

public class TapPagerAdapter extends FragmentStateAdapter {
    private ViewModel viewModel = new ViewModel();
    public TapPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Map(viewModel);
                break;
            case 1:
                fragment = new Data();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
