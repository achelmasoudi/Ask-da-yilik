package org.askidaiyilik.newfrojectfromLumotion2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments.AnaSyafaFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments.KayitOlFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Function Call
        aboutTheBotNavigation();

    }

    private void aboutTheBotNavigation() {

        BottomNavigationView navigationView = findViewById(R.id.BottomNavigationId);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Id , new AnaSyafaFragment()).addToBackStack(null).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.BottomNavigation_Items_AnaSyafaId:
                        selectedFragment = new AnaSyafaFragment();
                        break;
                    case R.id.BottomNavigation_Items_KayitOlId:
                        selectedFragment = new KayitOlFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Id ,
                        selectedFragment).addToBackStack(null).commit();
                return true;
            }
        });

    }

}