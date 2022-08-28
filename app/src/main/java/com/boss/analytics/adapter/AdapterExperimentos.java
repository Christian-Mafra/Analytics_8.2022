package com.boss.analytics.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.analytics.R;
import com.boss.analytics.activitys.NovoExperimentoActivity;
import com.boss.analytics.model.ExperimentoModel;

import java.util.List;

public class AdapterExperimentos extends RecyclerView.Adapter<AdapterExperimentos.MyViewHolder> {
    private List<ExperimentoModel> experimentoModelList;
    private Context context;

    public AdapterExperimentos(List<ExperimentoModel> experimentoModelList, Context context) {
        this.experimentoModelList = experimentoModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_experimentos,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExperimentoModel experimentoModel = experimentoModelList.get(position);
        holder.txtTitulo.setText(experimentoModel.getTitulo());
        holder.txtData.setText(experimentoModel.getData());
        if(experimentoModel.getImgPhoto()==0){
            holder.imgPhoto.setVisibility(View.GONE);
        }else{
            holder.imgPhoto.setImageResource(experimentoModel.getImgPhoto());
        }
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), NovoExperimentoActivity.class);
                intent.putExtra("titulo",experimentoModel.getTitulo());
                intent.putExtra("foto",experimentoModel.getImgPhoto());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        /*holder.imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */

    }

    @Override
    public int getItemCount() {
        return experimentoModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitulo, txtData;
        private ImageView imgPhoto;
        //private ImageButton imgMenu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtData = itemView.findViewById(R.id.txtData);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            //imgMenu = itemView.findViewById(R.id.imgMenu);
        }
    }
}
