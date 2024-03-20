package dataOfYardimIsteyenKisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.askidaiyilik.newfrojectfromLumotion2022.FaturaOdemek;
import org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil.FaturalarimFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.R;
import org.askidaiyilik.newfrojectfromLumotion2022.YardimIsteyenKisiActivity;

import controller.DataBaseHelper;
import model.Data;

public class AddFatura extends AppCompatActivity {

    private TextInputLayout faturaNumarasi , sozlesmeNumarasi;
    private Button ekleButton;

    private ImageView imageViewOfTypeOfkurumuFaturaEkle;
    private TextView textViewOfTypeOfkurumuFaturaEkle;

    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fatura);

        faturaNumarasi = findViewById(R.id.faturaNumarasiId);
        sozlesmeNumarasi = findViewById(R.id.sozlesmeNumarasiId);
        ekleButton = findViewById(R.id.ekleFaturaButton);

        dataBaseHelper = new DataBaseHelper(this);


        //Function GetOfYardimKisi KurumuSecmek
        sectigiKurumu();





        ekleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String faturaNo = faturaNumarasi.getEditText().getText().toString();
                String sozlesmeNo = sozlesmeNumarasi.getEditText().getText().toString();

                if(TextUtils.isEmpty(faturaNo) || TextUtils.isEmpty(sozlesmeNo)) {
                    Toast.makeText(AddFatura.this , "Lütfen bilgilerini gir", Toast.LENGTH_SHORT).show();
                }
                else {
                    dataBaseHelper.addData( new Data("178.23 TL" , faturaNo , sozlesmeNo) );

                    Intent intent = new Intent(AddFatura.this , YardimIsteyenKisiActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void sectigiKurumu() {

        imageViewOfTypeOfkurumuFaturaEkle = findViewById(R.id.imageViewOfTypeOfkurumuFaturaEkle);
        textViewOfTypeOfkurumuFaturaEkle = findViewById(R.id.textViewOfTypeOfkurumuFaturaEkle);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            int icon = bundle.getInt("icon");
            String type = bundle.getString("type");

            imageViewOfTypeOfkurumuFaturaEkle.setImageResource(icon);
            textViewOfTypeOfkurumuFaturaEkle.setText(type);
        }

    }
}