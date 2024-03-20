package org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.askidaiyilik.newfrojectfromLumotion2022.AnaSayfaAndKayitOlFragments.AnaSyafaFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.MainActivity;
import org.askidaiyilik.newfrojectfromLumotion2022.R;

public class ProfilimFragment extends Fragment {

    private LinearLayout cikisLinearLayoutFromYourAccount;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profilim_fragment , container , false);

        cikisLinearLayoutFromYourAccount = view.findViewById(R.id.cikisLinearLayoutFromYourAccountId);
        cikisLinearLayoutFromYourAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setCancelable(false);
                alertDialog.setTitle("Çıkış");
                alertDialog.setMessage("Çıkmak istediğinden emin misin !");
                alertDialog.setPositiveButton("Çıkış", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getActivity() , MainActivity.class);
                        getActivity().startActivity(intent);
                        getActivity().finish();
                    }
                });
                alertDialog.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        return view;
    }
}
