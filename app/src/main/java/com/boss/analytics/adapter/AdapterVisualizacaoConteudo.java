package com.boss.analytics.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.analytics.R;
import com.boss.analytics.activitys.Visualizacao1Activity;
import com.boss.analytics.model.VisualizacaoConteudoModel;

import java.util.List;

public class AdapterVisualizacaoConteudo extends RecyclerView.Adapter<AdapterVisualizacaoConteudo.MyViewHolder> {
    List<VisualizacaoConteudoModel> visualizacaoConteudo;
    private Context context;

    public AdapterVisualizacaoConteudo(List<VisualizacaoConteudoModel> ListavisualizacaoConteudo, Context context) {
        this.visualizacaoConteudo = ListavisualizacaoConteudo;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_visualizacao_conteudo,parent,false);
        return new AdapterVisualizacaoConteudo.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VisualizacaoConteudoModel visualizacaoConteudoModel = visualizacaoConteudo.get(position);
        holder.imagensCartazesVisualizacao.setImageResource(visualizacaoConteudoModel.getFoto());
        holder.imagensCartazesVisualizacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Visualizacao1Activity.class);
                intent.putExtra("foto",visualizacaoConteudoModel.getFoto());
                intent.putExtra("nome",""+visualizacaoConteudoModel.getNome());
                intent.putExtra("desc",""+visualizacaoConteudoModel.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.visualizacaoConteudo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagensCartazesVisualizacao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagensCartazesVisualizacao = itemView.findViewById(R.id.imageView25);
        }

    }
}
