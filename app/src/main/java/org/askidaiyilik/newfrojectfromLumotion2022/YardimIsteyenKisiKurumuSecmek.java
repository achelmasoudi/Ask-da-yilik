package org.askidaiyilik.newfrojectfromLumotion2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.askidaiyilik.newfrojectfromLumotion2022.ActivitiesOfFaturaAlmak.AksaGazActivity;
import org.askidaiyilik.newfrojectfromLumotion2022.ActivitiesOfFaturaAlmak.ElazigSuActivity;
import org.askidaiyilik.newfrojectfromLumotion2022.ActivitiesOfFaturaAlmak.FiratEdasActivity;

import dataOfYardimIsteyenKisi.AddFatura;

public class YardimIsteyenKisiKurumuSecmek extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout aksa , elazig , firat ;
    private RelativeLayout aksaGaz , elazigSu , firatEdas ;
    private TextView kurumusec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardim_isteyen_kisi_kurumu_secmek);

        //Function Of Animation
        animationFunction();

        //Initialize the Relative Layouts (Click Listener)
        aksaGaz = findViewById(R.id.aksagazRelativeLayoutIdYardimIsteyenKisi);
        elazigSu = findViewById(R.id.elazigsuRelativeLayoutIdYardimIsteyenKisi);
        firatEdas = findViewById(R.id.firatedasRelativeLayoutIdYardimIsteyenKisi);

        aksaGaz.setOnClickListener(this);
        elazigSu.setOnClickListener(this);
        firatEdas.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.aksagazRelativeLayoutIdYardimIsteyenKisi:
                Intent intent = new Intent(YardimIsteyenKisiKurumuSecmek.this , AddFatura.class);
                intent.putExtra("icon" , R.drawable.gaz_icon);
                intent.putExtra("type" , "AKSA GAZ");
                startActivity(intent);
                break;

            case R.id.elazigsuRelativeLayoutIdYardimIsteyenKisi:
                Intent intent1 = new Intent(YardimIsteyenKisiKurumuSecmek.this , AddFatura.class);
                intent1.putExtra("icon" , R.drawable.su_icon);
                intent1.putExtra("type" , "ELAZIĞ SU");
                startActivity(intent1);
                break;

            case R.id.firatedasRelativeLayoutIdYardimIsteyenKisi:
                Intent intent2 = new Intent(YardimIsteyenKisiKurumuSecmek.this , AddFatura.class);
                intent2.putExtra("icon" , R.drawable.elektrik_icon);
                intent2.putExtra("type" , "FIRAT EDAŞ");
                startActivity(intent2);
                break;
        }
    }


    private void animationFunction() {
        //Initialize the Relative Layouts
        aksa = findViewById(R.id.gaz_relativelayoutIdYardimIsteyenKisi);
        elazig = findViewById(R.id.su_relativelayoutIdYardimIsteyenKisi);
        firat = findViewById(R.id.elektrik_relativelayoutIdYardimIsteyenKisi);
        kurumusec = findViewById(R.id.kurumusecIdYardimIsteyenKisiActivity);

        aksa.setTranslationX(700);
        elazig.setTranslationX(-700);
        firat.setTranslationX(700);
        kurumusec.setTranslationY(-300);

        aksa.setAlpha(0);
        elazig.setAlpha(0);
        firat.setAlpha(0);
        kurumusec.setAlpha(0);

        aksa.animate().translationX(0).alpha(1).setDuration(700).setStartDelay(400).start();
        elazig.animate().translationX(0).alpha(1).setDuration(700).setStartDelay(550).start();
        firat.animate().translationX(0).alpha(1).setDuration(700).setStartDelay(700).start();
        kurumusec.animate().translationY(0).alpha(1).setDuration(700).setStartDelay(300).start();
    }
}