package org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments.GirisFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments.MyViewPagerAdapter;
import org.askidaiyilik.newfrojectfromLumotion2022.GirisAndUyeOlFragments.UyeOlFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.R;

public class KayitOlFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private ImageView lumotionLogo , AskidaIyilikLogo;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kayit_ol_fragment , container , false);


        lumotionLogo = view.findViewById(R.id.lumotionLogoIdForKayitOl);
        AskidaIyilikLogo = view.findViewById(R.id.askidaIyilikLogoForKayitOl);

        lumotionLogo.setTranslationY(-350);
        AskidaIyilikLogo.setTranslationY(-350);

        lumotionLogo.setAlpha(0.0f);
        AskidaIyilikLogo.setAlpha(0.0f);

        lumotionLogo.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        AskidaIyilikLogo.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();


        //Function Call
        aboutTabLayout();

        return view;
    }

    private void aboutTabLayout() {
        //Initialize the views
        viewPager = (ViewPager2) view.findViewById(R.id.viewPagerId);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayoutId);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        myViewPagerAdapter = new MyViewPagerAdapter(fragmentManager , getActivity().getLifecycle());

        viewPager.setAdapter(myViewPagerAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Giriş"));
        tabLayout.addTab(tabLayout.newTab().setText("Üye Ol"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}
