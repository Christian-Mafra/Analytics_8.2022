package com.boss.analytics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.analytics.R;
import com.boss.analytics.model.GruposCations;

import java.util.List;

public class AdapterGruposCations extends RecyclerView.Adapter<AdapterGruposCations.MyViewHolder>{
    private List<GruposCations> gruposCations;
    private RecyclerViewClickListner listner;

    public AdapterGruposCations(List<GruposCations> gruposCations, RecyclerViewClickListner listner) {
        this.gruposCations = gruposCations;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_grupos_cations,parent,false);

        return new MyViewHolder(itemLista);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GruposCations grupoCation = gruposCations.get(position);
        holder.cations.setText(grupoCation.getCations());
        holder.imagem.setImageResource(grupoCation.getImagem());
    }

    @Override
    public int getItemCount() { return 5;}

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView cations;
        private ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cations = itemView.findViewById(R.id.txtAnions);
            imagem = itemView.findViewById(R.id.imageGruposAnions);
            itemView.setOnClickListener(this);

        }

        @Override public void onClick(View view) {
            listner.onClick(view, getAdapterPosition());
        }
    }

}

