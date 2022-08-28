package com.boss.analytics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boss.analytics.R;
import com.boss.analytics.model.FluxogramaAnalisesModel;

import java.util.List;

public class AdapterFluxogramaAnalise extends RecyclerView.Adapter<AdapterFluxogramaAnalise.MyViewHolder> {
    private List<FluxogramaAnalisesModel> analisesModels;
    private RecyclerViewClickListner listner;
    private int contaCartao=0;


    public AdapterFluxogramaAnalise(List<FluxogramaAnalisesModel> analisesModels, RecyclerViewClickListner listner) {
        this.analisesModels = analisesModels;
        this.listner = listner;
    }

    public AdapterFluxogramaAnalise() {
    }

    @NonNull
    @Override
    public AdapterFluxogramaAnalise.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_fluxograma_analise,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFluxogramaAnalise.MyViewHolder holder, int position) {
        position = this.contaCartao;
        FluxogramaAnalisesModel analisesModel = analisesModels.get(position);
        holder.txtPasso.setText(analisesModel.getPasso());
        holder.txtProcedimentos.setText(analisesModel.getProcedimento());
        holder.imagemInfo.setImageResource(analisesModel.getImageInfo());
        holder.radio1.setText(analisesModel.getRadio1());
        holder.radio2.setText(analisesModel.getRadio2());
        if(analisesModel.getRadio3() != null){holder.radio3.setText(analisesModel.getRadio3());}else{holder.radio3.setVisibility(View.GONE);}
        holder.buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int z = analisesModels.size() - 1;
                if(contaCartao == z){
                    contaCartao = 0;
                    FluxogramaAnalisesModel analisesModel = analisesModels.get(contaCartao);
                    holder.txtPasso.setText(analisesModel.getPasso());
                    holder.txtProcedimentos.setText(analisesModel.getProcedimento());
                    holder.imagemInfo.setImageResource(analisesModel.getImageInfo());
                    holder.radio1.setText(analisesModel.getRadio1());
                    holder.radio2.setText(analisesModel.getRadio2());
                    if(analisesModel.getRadio3() != null){holder.radio3.setText(analisesModel.getRadio3());}else{holder.radio3.setVisibility(View.GONE);}
                }
                else{
                    contaCartao = contaCartao + 1;
                    FluxogramaAnalisesModel analisesModel = analisesModels.get(contaCartao);
                    holder.txtPasso.setText(analisesModel.getPasso());
                    holder.txtProcedimentos.setText(analisesModel.getProcedimento());
                    holder.imagemInfo.setImageResource(analisesModel.getImageInfo());
                    holder.radio1.setText(analisesModel.getRadio1());
                    holder.radio2.setText(analisesModel.getRadio2());
                    if(analisesModel.getRadio3() != null){holder.radio3.setText(analisesModel.getRadio3());}else{holder.radio3.setVisibility(View.GONE);}
                }
            }
        });

        holder.buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contaCartao == 0){

                }else{
                    contaCartao = contaCartao - 1;
                    FluxogramaAnalisesModel analisesModel = analisesModels.get(contaCartao);
                    holder.txtPasso.setText(analisesModel.getPasso());
                    holder.txtProcedimentos.setText(analisesModel.getProcedimento());
                    holder.imagemInfo.setImageResource(analisesModel.getImageInfo());
                    holder.radio1.setText(analisesModel.getRadio1());
                    holder.radio2.setText(analisesModel.getRadio2());
                    if(analisesModel.getRadio3() != null){holder.radio3.setText(analisesModel.getRadio3());}else{holder.radio3.setVisibility(View.GONE);}
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtPasso, txtProcedimentos;
        private ImageView imagemInfo;
        private RadioButton radio1, radio2, radio3;
        private Button buttonAvancar, buttonVoltar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPasso = itemView.findViewById(R.id.txtPasso);
            txtProcedimentos = itemView.findViewById(R.id.txtProcedimento);
            imagemInfo = itemView.findViewById(R.id.imagemInfo);
            radio1 = itemView.findViewById(R.id.radioButton1);
            radio2 = itemView.findViewById(R.id.radioButton2);
            radio3 = itemView.findViewById(R.id.radioButton3);
            buttonAvancar = itemView.findViewById(R.id.buttonAvancar);
            buttonVoltar = itemView.findViewById(R.id.buttonVoltar);
            itemView.setOnClickListener(this);

        }

        public void onClick(View view) {
            listner.onClick(view, getAdapterPosition());
        }
    }
}

