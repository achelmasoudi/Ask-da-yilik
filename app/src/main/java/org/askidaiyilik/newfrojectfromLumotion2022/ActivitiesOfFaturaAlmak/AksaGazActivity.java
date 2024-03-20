package org.askidaiyilik.newfrojectfromLumotion2022.ActivitiesOfFaturaAlmak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.askidaiyilik.newfrojectfromLumotion2022.Adapter.MyAdapterOfAksaGaz;
import org.askidaiyilik.newfrojectfromLumotion2022.Model.AksaGazFaturaModel;
import org.askidaiyilik.newfrojectfromLumotion2022.R;

import java.util.ArrayList;
import java.util.List;

public class AksaGazActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<AksaGazFaturaModel> aksaGazFaturaModelList;
    private MyAdapterOfAksaGaz myAdapterOfAksaGaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksa_gaz);

        //Initialiaze The Variables
        recyclerView = findViewById(R.id.RecyclerViewOfAksaGazId);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this , 2);
        recyclerView.setLayoutManager(layoutManager);

        String tarih[] = {"05 Ocak" , "16 Temmuz" , "22 Eylül" , "27 Mart" , "10 Kasım" , "18 Şubat",
                "05 Ağustos" , "16 Nisan" , "22 Mayıs" , "09 Haziran" , "10 Ekim" , "30 Aralık" ,
                "12 Nisan" , "24 Ocak" , "04 Mayıs" , "20 Ağustos" , "18 Kasım" , "23 Şubat",
                "01 Ekim" , "19 Şubat" , "28 Temmuz" , "14 Nisan" , "27 Mart" , "18 Ocak",
                "05 Haziran" , "16 Ağustos" , "22 Ekim" , "11 Mayıs" , "10 Kasım" , "07 Aralık",
                "01 Ekim" , "19 Şubat" , "28 Temmuz" , "14 Nisan" , "27 Mart" , "18 Ocak",
                "05 Haziran" , "16 Ağustos" , "22 Ekim" , "11 Mayıs" , "10 Kasım" , "07 Aralık",
                "01 Ekim" , "19 Şubat" , "28 Temmuz" , "14 Nisan" , "27 Mart" , "18 Ocak",
                "05 Haziran" , "16 Ağustos" , "22 Ekim" , "11 Mayıs" , "10 Kasım" , "07 Aralık"};

        String fiyat[] = {"205 TL","1058 TL","132.52 TL","235.3 TL","105.3 TL","295 TL","435 TL","806.32 TL","45.3 TL","709 TL"
                ,"641.5 TL","203.5 TL","550.3 TL","771 TL","503 TL","895.68 TL","236 TL","1293.5 TL",
                "500 TL","875 TL","751.2 TL","235.3 TL","705 TL","98.5 TL","199 TL","326.3 TL","645 TL","126.52 TL"
                ,"221 TL","451 TL",
                "209 TL","103.3 TL","98.52 TL","235.3 TL","105.3 TL","230 TL","435 TL","806.32 TL","45.3 TL","709 TL"
                ,"641.5 TL","203.5 TL","210.3 TL","771 TL","515 TL","895.68 TL","546 TL","51.5 TL",
                "500 TL","875 TL","751.2 TL","235.3 TL","705 TL","98.5 TL","199 TL","326.3 TL","645 TL","126.52 TL"
                ,"221 TL","540 TL",
                "205 TL","389 TL","132.52 TL","235.3 TL","105.3 TL","295 TL","435 TL","806.32 TL","953.3 TL","709 TL"
                ,"641.5 TL","203.5 TL","550.3 TL","771 TL","503 TL","895.68 TL","583 TL","1293.5 TL",
                "500 TL","875 TL","751.2 TL","235.3 TL","705 TL","98.5 TL","199 TL","326.3 TL","325 TL","126.52 TL"
                ,"221 TL","451 TL"};

        aksaGazFaturaModelList = new ArrayList<>();

        for(int i=0 ; i<tarih.length; i++) {
            AksaGazFaturaModel aksaGazFatura = new AksaGazFaturaModel(tarih[i] , fiyat[i]);
            aksaGazFaturaModelList.add(aksaGazFatura);
        }

        myAdapterOfAksaGaz = new MyAdapterOfAksaGaz(this , aksaGazFaturaModelList);
        recyclerView.setAdapter(myAdapterOfAksaGaz);

    }
}