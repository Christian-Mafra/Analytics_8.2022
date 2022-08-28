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
import com.boss.analytics.model.CartazHorizontalModel;
import java.util.List;

public class AdapterCartazHorizontal extends RecyclerView.Adapter<AdapterCartazHorizontal.MyViewHolder> {
    List<CartazHorizontalModel> cartazHorizontal;
    private Context context;

    public AdapterCartazHorizontal(List<CartazHorizontalModel> cartazHorizontal, Context context) {
        this.cartazHorizontal = cartazHorizontal;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_cartaz_horizontal,parent,false);
        return new AdapterCartazHorizontal.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CartazHorizontalModel horizontalModel = cartazHorizontal.get(position);
        holder.imageHorizontal.setImageResource(horizontalModel.getFoto());
        holder.imageHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Visualizacao1Activity.class);
                intent.putExtra("foto",horizontalModel.getFoto());
                intent.putExtra("nome",""+horizontalModel.getNome());
                intent.putExtra("desc",""+horizontalModel.getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartazHorizontal.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageHorizontal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHorizontal = itemView.findViewById(R.id.imageViewCartazHorizontal);
        }
    }
}