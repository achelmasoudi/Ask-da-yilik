package controller;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.askidaiyilik.newfrojectfromLumotion2022.FragmentsOfFaturalarimAndProfil.FaturalarimFragment;
import org.askidaiyilik.newfrojectfromLumotion2022.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dataOfYardimIsteyenKisi.EditFatura;
import model.Data;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Data> dataList;
    private DataBaseHelper dataBaseHelper;
    private AlertDialog.Builder alertDialog;

    public Adapter(Context pContext , List<Data> pDataList) {
        this.context = pContext;
        this.dataList = pDataList;
    }

    public Adapter(Context pContext , List<Data> pDataList , DataBaseHelper pDataBaseHelper) {
        this.context = pContext;
        this.dataList = pDataList;
        this.dataBaseHelper = pDataBaseHelper;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_of_background_fatura_eklemek_yardimisteyenkisi , parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Data data = dataList.get(position);
        holder.faturafiyatiIdDuzenleme.setText(data.getFiyat());
        holder.faturaTarihiIdDuzenleme.setText(formatDate(data.getTimeStamp()));
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , EditFatura.class);
                intent.putExtra("position" , String.valueOf(data.getId()) );
                context.startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new AlertDialog.Builder(context);
                alertDialog.setCancelable(false);
                alertDialog.setTitle("KALDIR");
                alertDialog.setMessage("Silmek istediğinden emin misin !");
                alertDialog.setPositiveButton("KALDIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteOfData(position);
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
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView faturaTarihiIdDuzenleme;
        private TextView faturafiyatiIdDuzenleme;
        private LinearLayout edit , delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            faturaTarihiIdDuzenleme = itemView.findViewById(R.id.faturaTarihiIdDuzenleme);
            faturafiyatiIdDuzenleme = itemView.findViewById(R.id.faturafiyatiIdDuzenleme);
            edit = itemView.findViewById(R.id.linearLayoutOfDUZENLEid);
            delete = itemView.findViewById(R.id.linearLayoutOfKALDIRid);

        }
    }

    public String formatDate(String timeStamp) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(timeStamp);
            SimpleDateFormat newSdf = new SimpleDateFormat("MMM d");
            return newSdf.format(date);
        } catch (ParseException e) {
            Log.e("ERROR" , e.getMessage());
        }
        return "";

    }

    public void deleteOfData(int position) {
        dataBaseHelper.deleteData(dataList.get(position));
        dataList.remove(position);
        FaturalarimFragment.notifyAdapter();
    }
}