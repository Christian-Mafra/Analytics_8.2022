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
import com.boss.analytics.model.ContinueEstudandoModel;

import java.util.List;

public class AdapterContinueEstudando extends RecyclerView.Adapter<AdapterContinueEstudando.MyViewHolder> {
    private List<ContinueEstudandoModel> continueEstudandoModel;
    private Context context;

    public AdapterContinueEstudando(List<ContinueEstudandoModel> continueEstudandoModelList, Context context) {
        this.continueEstudandoModel = continueEstudandoModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_continue_estudando,parent,false);
        return new AdapterContinueEstudando.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ContinueEstudandoModel continueEstudando = continueEstudandoModel.get(position);
        holder.imageView.setImageResource(continueEstudando.getFoto());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Visualizacao1Activity.class);
                intent.putExtra("foto",continueEstudando.getFoto());
                intent.putExtra("nome",""+continueEstudando.getNome());
                intent.putExtra("desc",""+continueEstudando.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return continueEstudandoModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewContinuemEstudando);
        }
    }
}
