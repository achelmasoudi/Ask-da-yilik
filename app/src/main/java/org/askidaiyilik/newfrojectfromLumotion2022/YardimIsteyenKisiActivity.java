package org.askidaiyilik.newfrojectfromLumotion2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments.AnaSyafaFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments.KayitOlFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil.FaturalarimFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil.ProfilimFragment;

import controller.Adapter;
import controller.DataBaseHelper;
import dataOfYardimIsteyenKisi.AddFatura;

public class YardimIsteyenKisiActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardim_isteyen_kisi);


        floatingActionButton = findViewById(R.id.floatingActionBar);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YardimIsteyenKisiActivity.this , YardimIsteyenKisiKurumuSecmek.class);
                startActivity(intent);
            }
        });

        bottomNavigation();

    }

    private void bottomNavigation() {

        BottomNavigationView navigationView = findViewById(R.id.bottomNavForYardimIsteyenActivity);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Id_Of_YardimIsteyen , new FaturalarimFragment()).addToBackStack(null).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.BottomNavigation_Items_FaturalarimId:
                        selectedFragment = new FaturalarimFragment();
                        break;
                    case R.id.BottomNavigation_Items_ProfilimId:
                        selectedFragment = new ProfilimFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Id_Of_YardimIsteyen ,
                        selectedFragment).addToBackStack(null).commit();
                return true;
            }
        });

    }
}