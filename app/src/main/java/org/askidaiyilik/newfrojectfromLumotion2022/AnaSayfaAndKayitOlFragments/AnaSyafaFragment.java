package org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import org.askidaiyilik.newfrojectfromLumotion2022.FaturayiAlActivity;
import org.askidaiyilik.newfrojectfromLumotion2022.R;


public class AnaSyafaFragment extends Fragment {

    private View view;
    private CardView faturaAl;
    private RelativeLayout askidanAlinan , askidaBekleyen , toplamOdenen;
    private TextView askidaGuncelDurum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ana_sayfa_fragment , container , false);

        askidanAlinan = view.findViewById(R.id.RelativeLayoutAskidanAlinanFaturaId);
        askidaBekleyen = view.findViewById(R.id.RelativeLayoutAskidanBekleyenFaturaId);
        toplamOdenen = view.findViewById(R.id.RelativeLayoutToplamOdenenId);
        faturaAl = view.findViewById(R.id.FaturaAl_Id);
        askidaGuncelDurum = view.findViewById(R.id.textViewOfAskidaFGuncelDurum);

        //Animation Of Card Views
        cardViewAnimationFunction();

        faturaAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity() , FaturayiAlActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void cardViewAnimationFunction() {
        askidanAlinan.setTranslationX(800);
        askidaBekleyen.setTranslationX(800);
        toplamOdenen.setTranslationX(800);
        faturaAl.setTranslationY(400);
        askidaGuncelDurum.setTranslationY(-300);


        askidanAlinan.setAlpha(0);
        askidaBekleyen.setAlpha(0);
        toplamOdenen.setAlpha(0);
        faturaAl.setAlpha(0);
        askidaGuncelDurum.setAlpha(0);

        askidanAlinan.animate().translationX(0).alpha(1).setDuration(700).setStartDelay(400).start();
        askidaBekleyen.animate().translationX(0).alpha(1).setDuration(700).setStartDelay(550).start();
        toplamOdenen.animate().translationX(0).alpha(1).setDuration(700).setStartDelay(700).start();
        faturaAl.animate().translationY(0).alpha(1).setDuration(700).setStartDelay(600).start();
        askidaGuncelDurum.animate().translationY(0).alpha(1).setDuration(700).setStartDelay(300).start();
    }


}
