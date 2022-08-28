package com.boss.analytics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.analytics.R;
import com.boss.analytics.model.QuemSomosModel;

import java.util.List;

public class AdapterQuemSomos extends RecyclerView.Adapter<AdapterQuemSomos.MyViewHolder> {
    private List<QuemSomosModel> quemSomosModels;

    public AdapterQuemSomos(List<QuemSomosModel> quemSomosList) {
        this.quemSomosModels = quemSomosList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_quem_somos,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        QuemSomosModel quemSomosModel = quemSomosModels.get(position);
        holder.textViewNomeQuemSomos.setText(quemSomosModel.getTextViewNomeQuemSomos());
        holder.imageViewFoto.setImageResource(quemSomosModel.getFoto());
        holder.info1QuemSomos.setText(quemSomosModel.getInfo1QuemSomos());
        holder.info2QuemSomos.setText(quemSomosModel.getInfo2QuemSomos());
        holder.info3QuemSomos.setText(quemSomosModel.getInfo3QuemSomos());
        holder.cardViewQuemSomos.setCardBackgroundColor(quemSomosModel.getCardViewQuemSomos());
    }

    @Override
    public int getItemCount() {
        return quemSomosModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewFoto;
        private TextView textViewNomeQuemSomos;
        private TextView info1QuemSomos;
        private TextView info2QuemSomos;
        private TextView info3QuemSomos;
        private CardView cardViewQuemSomos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewNomeQuemSomos = itemView.findViewById(R.id.textViewNomeQuemSomos);
            info1QuemSomos = itemView.findViewById(R.id.info1QuemSomos);
            info2QuemSomos = itemView.findViewById(R.id.info2QuemSomos);
            info3QuemSomos = itemView.findViewById(R.id.info3QuemSomos);
            cardViewQuemSomos = itemView.findViewById(R.id.cardViewQuemSomos);

        }
    }
}

