package org.askidaiyilik.newfrojectfromLumotion2022.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.askidaiyilik.newfrojectfromLumotion2022.FaturaOdemek;
import org.askidaiyilik.newfrojectfromLumotion2022.Model.FiratEdasFaturaModel;
import org.askidaiyilik.newfrojectfromLumotion2022.R;

import java.util.List;

public class MyAdapterOfFiratEdas extends RecyclerView.Adapter<MyAdapterOfFiratEdas.MyViewHolder> {

    private Context context;
    private List<FiratEdasFaturaModel> firatEdasFaturaModelList;

    public MyAdapterOfFiratEdas(Context context, List<FiratEdasFaturaModel> firatEdasFaturaModelList) {
        this.context = context;
        this.firatEdasFaturaModelList = firatEdasFaturaModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aksa_gaz_list_row_custom , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext() , android.R.anim.slide_in_left);
        FiratEdasFaturaModel firatEdasFaturaModel = firatEdasFaturaModelList.get(position);
        holder.faturaTarihi.setText(firatEdasFaturaModel.getFaturaTarihi());
        holder.faturaFiyati.setText(firatEdasFaturaModel.getFaturaFiyati());
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return firatEdasFaturaModelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView faturaTarihi , faturaFiyati;
        private Button simdiOdeButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            faturaTarihi = itemView.findViewById(R.id.faturaTarihiId);
            faturaFiyati = itemView.findViewById(R.id.faturafiyatiId);
            simdiOdeButton = itemView.findViewById(R.id.simdiOdeBottonId);

            simdiOdeButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context , FaturaOdemek.class);
            int position = getAdapterPosition();
            FiratEdasFaturaModel firatEdasFaturaModel = firatEdasFaturaModelList.get(position);
            intent.putExtra("fiyat" , firatEdasFaturaModel.getFaturaFiyati());
            context.startActivity(intent);
        }
    }
}
