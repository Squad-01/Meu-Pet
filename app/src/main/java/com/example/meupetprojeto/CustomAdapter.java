package com.example.meupetprojeto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList nomepet,hospedagem,spa,banhotosa,obs;

    CustomAdapter(Context context, ArrayList nomepet,
                  ArrayList hospedagem,
                  ArrayList spa,
                  ArrayList banhotosa,
                  ArrayList obs){
        this.context = context;
        this.nomepet = nomepet;
        this.hospedagem = hospedagem;
        this.spa = spa;
        this.banhotosa = banhotosa;
        this.obs = obs;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_nomepet_agenda3.setText(String.valueOf(nomepet.get(position)));
        holder.tv_hospedagem_agenda2.setText(String.valueOf(hospedagem.get(position)));
        holder.tv_spa_agenda2.setText(String.valueOf(spa.get(position)));
        holder.tv_banhotosa_agenda2.setText(String.valueOf(banhotosa.get(position)));
        holder.tv_obs_agenda2.setText(String.valueOf(obs.get(position)));

    }

    @Override
    public int getItemCount() {

        return nomepet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nomepet_agenda3,tv_hospedagem_agenda2,tv_spa_agenda2,tv_banhotosa_agenda2,tv_obs_agenda2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nomepet_agenda3 = itemView.findViewById(R.id.tv_nomepet_agenda3);
            tv_hospedagem_agenda2 = itemView.findViewById(R.id.tv_hospedagem_agenda2);
            tv_spa_agenda2 = itemView.findViewById(R.id.tv_spa_agenda2);
            tv_banhotosa_agenda2 = itemView.findViewById(R.id.tv_banhotosa_agenda2);
            tv_obs_agenda2 = itemView.findViewById(R.id.tv_obs_agenda2);



        }
    }
}
