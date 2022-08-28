package com.boss.analytics.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.boss.analytics.R;
import com.boss.analytics.activitys.Visualizacao1Activity;
import com.boss.analytics.model.CartazVerticalModel;

import java.util.List;

public class AdapterCartazVerticalMaisConteudo extends RecyclerView.Adapter<AdapterCartazVerticalMaisConteudo.MyViewHolder> {
    private List<CartazVerticalModel> cartazVerticalModels;
    private Context context;

    public AdapterCartazVerticalMaisConteudo(List<CartazVerticalModel> cartazVerticalModels, Context context) {
        this.cartazVerticalModels = cartazVerticalModels;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_cartaz_vertical_mais_conteudo,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        CartazVerticalModel cartazVerticalModela = cartazVerticalModels.get(position);
        holder.imageView.setImageResource(cartazVerticalModela.getFoto());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Visualizacao1Activity.class);
                intent.putExtra("foto",cartazVerticalModela.getFoto());
                intent.putExtra("nome",""+cartazVerticalModela.getNome());
                intent.putExtra("desc",""+cartazVerticalModela.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartazVerticalModels.size();
    }

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private int img;
        private TextView txt;



        public MyViewHolder( View itemView) {
            super(itemView);
            imageView  = itemView.findViewById(R.id.imageViewCartazVertical);
            txt  = itemView.findViewById(R.id.txtNomeConteudo);
        }

    }
}
