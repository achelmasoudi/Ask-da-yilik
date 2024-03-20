package dataOfYardimIsteyenKisi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil.FaturalarimFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.R;
import org.askidaiyilik.newfrojectfromLumotion2022.YardimIsteyenKisiActivity;

import controller.DataBaseHelper;
import model.Data;

public class EditFatura extends AppCompatActivity {

    private TextInputLayout faturaNumarasiIdDuzenleyiniz , sozlesmeNumarasiIdDuzenleyiniz;
    private Button DuzenleFaturaButton;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_fatura);

        faturaNumarasiIdDuzenleyiniz = findViewById(R.id.faturaNumarasiIdDuzenleyiniz);
        sozlesmeNumarasiIdDuzenleyiniz = findViewById(R.id.sozlesmeNumarasiIdDuzenleyiniz);
        DuzenleFaturaButton = findViewById(R.id.DuzenleFaturaButton);

        dataBaseHelper = new DataBaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        String strbundle = bundle.getString("position");
        Data data = dataBaseHelper.getData(Integer.parseInt(strbundle));

        if( data != null ) {
            faturaNumarasiIdDuzenleyiniz.getEditText().setText(data.getFaturaNo());
            sozlesmeNumarasiIdDuzenleyiniz.getEditText().setText(data.getSozlesmeNo());
        }

        DuzenleFaturaButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                data.setFaturaNo(faturaNumarasiIdDuzenleyiniz.getEditText().getText().toString());
                data.setSozlesmeNo(sozlesmeNumarasiIdDuzenleyiniz.getEditText().getText().toString());

                if(TextUtils.isEmpty(faturaNumarasiIdDuzenleyiniz.getEditText().getText().toString()) || TextUtils.isEmpty(sozlesmeNumarasiIdDuzenleyiniz.getEditText().getText().toString())) {
                    Toast.makeText(EditFatura.this , "Lütfen bilgilerini gir", Toast.LENGTH_SHORT).show();
                }
                else {
                    dataBaseHelper.updateData(data);
                    FaturalarimFragment.notifyAdapter();


                    Intent intent = new Intent(EditFatura.this, YardimIsteyenKisiActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}