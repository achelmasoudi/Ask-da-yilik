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

public class FaturayiAlActivity extends AppCompatActivity {

    private RelativeLayout aksa , elazig , firat ;
    private RelativeLayout aksaGaz , elazigSu , firatEdas ;
    private TextView kurumusec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faturayi_al);

        //Function Of Click Listener
        clickFunction();

        //Function Of Animation
        animationFunction();

    }

    private void clickFunction() {
        //Initialize the Relative Layouts
        aksaGaz = findViewById(R.id.aksagazRelativeLayoutId);
        elazigSu = findViewById(R.id.elazigsuRelativeLayoutId);
        firatEdas = findViewById(R.id.firatedasRelativeLayoutId);



        aksaGaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FaturayiAlActivity.this , AksaGazActivity.class);
                startActivity(intent);
            }
        });

        elazigSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FaturayiAlActivity.this , ElazigSuActivity.class);
                startActivity(intent);
            }
        });

        firatEdas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FaturayiAlActivity.this , FiratEdasActivity.class);
                startActivity(intent);
            }
        });

    }

    private void animationFunction() {

        //Initialize the Relative Layouts
        aksa = findViewById(R.id.gaz_relativelayoutId);
        elazig = findViewById(R.id.su_relativelayoutId);
        firat = findViewById(R.id.elektrik_relativelayoutId);
        kurumusec = findViewById(R.id.kurumusecId);

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