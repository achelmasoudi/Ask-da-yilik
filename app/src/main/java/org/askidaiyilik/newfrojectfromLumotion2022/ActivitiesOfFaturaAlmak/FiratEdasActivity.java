package org.askidaiyilik.newfrojectfromLumotion2022.ActivitiesOfFaturaAlmak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.askidaiyilik.newfrojectfromLumotion2022.Adapter.MyAdapterOfElazigSu;
import org.askidaiyilik.newfrojectfromLumotion2022.Adapter.MyAdapterOfFiratEdas;
import org.askidaiyilik.newfrojectfromLumotion2022.Model.ElazigSuFaturaModel;
import org.askidaiyilik.newfrojectfromLumotion2022.Model.FiratEdasFaturaModel;
import org.askidaiyilik.newfrojectfromLumotion2022.R;

import java.util.ArrayList;
import java.util.List;


public class FiratEdasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<FiratEdasFaturaModel> firatEdasFaturaModelList;
    private MyAdapterOfFiratEdas myAdapterOfFiratEdas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksa_gaz);

        //Initialiaze The Variables
        recyclerView = findViewById(R.id.RecyclerViewOfAksaGazId);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this , 2);
        recyclerView.setLayoutManager(layoutManager);

        String tarih[] = {"05 NISAN" , "16 OCAK" , "22 TEMMUZ" , "29 MART" , "10 MAYIS" , "18 HAZIRAN",
                "05 NISAN" , "16 OCAK" , "22 TEMMUZ" , "29 MART" , "10 MAYIS" , "18 HAZIRAN" ,
                "05 NISAN" , "16 OCAK" , "22 TEMMUZ" , "29 MART" , "10 MAYIS" , "18 HAZIRAN",
                "05 NISAN" , "16 OCAK" , "22 TEMMUZ" , "29 MART" , "10 MAYIS" , "18 HAZIRAN",
                "25 NISAN" , "14 OCAK" , "23 TEMMUZ" , "10 MART" , "2 MAYIS" , "27 HAZIRAN"};

        String fiyat[] = {"205 TL","1058 TL","132.52 TL","235.3 TL","105.3 TL","295 TL","435 TL","806.32 TL","45.3 TL","709 TL"
                ,"641.5 TL","203.5 TL","550.3 TL","771 TL","503 TL","895.68 TL","236 TL","1293.5 TL",
                "500 TL","875 TL","751.2 TL","235.3 TL","705 TL","98.5 TL","199 TL","326.3 TL","645 TL","126.52 TL"
                ,"221 TL","451 TL"};

        firatEdasFaturaModelList = new ArrayList<>();

        for(int i=0 ; i<tarih.length; i++) {
            FiratEdasFaturaModel firatEdasFatura = new FiratEdasFaturaModel(tarih[i] , fiyat[i]);
            firatEdasFaturaModelList.add(firatEdasFatura);
        }

        myAdapterOfFiratEdas = new MyAdapterOfFiratEdas(this , firatEdasFaturaModelList);
        recyclerView.setAdapter(myAdapterOfFiratEdas);
    }
}