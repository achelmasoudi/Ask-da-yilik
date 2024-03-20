package org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.askidaiyilik.newfrojectfromLumotion2022.R;

import controller.Adapter;
import controller.DataBaseHelper;

public class FaturalarimFragment extends Fragment {

    private static Adapter adapter;
    private RecyclerView recyclerView;
    private DataBaseHelper dataBaseHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faturalarim_fragmemt , container , false);

        recyclerView = view.findViewById(R.id.RecyclerViewOfEklidigiFaturalarId);
        dataBaseHelper = new DataBaseHelper(getContext());

        adapter = new Adapter( getContext() , dataBaseHelper.getAllData() , dataBaseHelper );

        GridLayoutManager layoutManager = new GridLayoutManager(getContext() , 2);
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setItemAnimator( new DefaultItemAnimator() );
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public static void notifyAdapter() {
        adapter.notifyDataSetChanged();
    }

}
