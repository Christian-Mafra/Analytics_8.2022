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
import com.boss.analytics.activitys.Visualizacao1Activity;
import com.boss.analytics.model.ShortbookModel;

import java.util.List;

public class AdapterShortBook extends RecyclerView.Adapter<AdapterShortBook.MyViewHolder> {
    private List<ShortbookModel> listShortbook;
    private Context context;

    public AdapterShortBook(List<ShortbookModel> listShortbook, Context context) {
        this.listShortbook = listShortbook;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_shortbook,parent,false);
        return new AdapterShortBook.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ShortbookModel shortbookModel = this.listShortbook.get(position);
        holder.txt.setText(shortbookModel.getNome());
        holder.desc.setText(shortbookModel.getDesc());
        holder.imageView.setImageResource(shortbookModel.getFoto());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Visualizacao1Activity.class);
                intent.putExtra("foto",shortbookModel.getFoto());
                intent.putExtra("nome",""+shortbookModel.getNome());
                intent.putExtra("desc",""+shortbookModel.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listShortbook.size();
    }

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView txt, desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView6);
            txt = itemView.findViewById(R.id.textView13);
            desc = itemView.findViewById(R.id.textView15);
        }
    }
}
