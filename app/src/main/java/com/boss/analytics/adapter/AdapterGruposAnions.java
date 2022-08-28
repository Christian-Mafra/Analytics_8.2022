package com.boss.analytics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.analytics.R;
import com.boss.analytics.model.GruposAnions;

import java.util.List;

public class AdapterGruposAnions extends RecyclerView.Adapter<AdapterGruposAnions.MyViewHolder> {
    private List<GruposAnions> gruposAnions;
    private RecyclerViewClickListner listner;

    public AdapterGruposAnions(List<GruposAnions> gruposAnions, RecyclerViewClickListner listner) {
        this.gruposAnions = gruposAnions;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_grupos_anions,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GruposAnions grupoAnions = gruposAnions.get(position);
        holder.grupos.setText(grupoAnions.getGrupos());
        holder.anions.setText(grupoAnions.getAnions());
        holder.imagem.setImageResource(grupoAnions.getImagem());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView grupos, anions;
        private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            grupos = itemView.findViewById(R.id.txtGruposAnions);
            anions = itemView.findViewById(R.id.txtAnions);
            imagem = itemView.findViewById(R.id.imageGruposAnions);
            itemView.setOnClickListener(this);
        }
        @Override public void onClick(View view) {
            listner.onClick(view, getAdapterPosition());
        }

    }
}