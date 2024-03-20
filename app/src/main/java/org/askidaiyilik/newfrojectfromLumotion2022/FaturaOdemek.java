
package org.askidaiyilik.newfrojectfromLumotion2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.askidaiyilik.newfrojectfromLumotion2022.ActivitiesOfFaturaAlmak.AksaGazActivity;

public class FaturaOdemek extends AppCompatActivity {

    private TextView fiyat;
    private Button odemeTamamla , vazgec;
    private TextInputLayout kartNoId , kartSahibininadiId , sonKullanmatarihi , CVC2Id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura_odemek);

        kartNoId = findViewById(R.id.kartNoId);
        kartSahibininadiId = findViewById(R.id.kartSahibininadiId);
        sonKullanmatarihi = findViewById(R.id.sonKullanmatarihi);
        CVC2Id = findViewById(R.id.CVC2Id);

        //function Of the fiyat
        fiyatFunc();

        //Odeme Tamamla Function
        odemeTamamlaFunc();

        //Odemeden Vazgec Function
        vazgecFunc();

    }

    private void odemeTamamlaFunc() {
        odemeTamamla = findViewById(R.id.odemeTamamlaButtonId);
        odemeTamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( TextUtils.isEmpty(kartNoId.getEditText().getText().toString()) || TextUtils.isEmpty(kartSahibininadiId.getEditText().getText().toString()) ||
                        TextUtils.isEmpty(sonKullanmatarihi.getEditText().getText().toString()) || TextUtils.isEmpty(CVC2Id.getEditText().getText().toString()) ) {
                    Toast.makeText(FaturaOdemek.this ,"Lütfen bilgilerinizi giriniz" , Toast.LENGTH_SHORT ).show();
                }
                else {
                    Intent intent = new Intent(FaturaOdemek.this , AksaGazActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(FaturaOdemek.this ,"İşleminiz başarıyla gerçekleşmiştir" , Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }

    private void vazgecFunc() {
        vazgec = findViewById(R.id.vazgecButtonId);
        vazgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FaturaOdemek.this , AksaGazActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void fiyatFunc() {
        fiyat = findViewById(R.id.faturafiyatiOdemekActivityId);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String newFiyat = bundle.getString("fiyat");
            fiyat.setText(newFiyat);
        }
    }



}