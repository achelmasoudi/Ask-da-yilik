package org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    private FragmentManager fragmentManager;
    private Lifecycle lifecycle;
    public MyViewPagerAdapter(FragmentManager fragmentManager , Lifecycle lifecycle) {
        super(fragmentManager , lifecycle);
        this.fragmentManager = fragmentManager;
        this.lifecycle = lifecycle;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new UyeOlFragment();
        }
        return new GirisFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
