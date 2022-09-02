package com.boss.analytics.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boss.analytics.R;
import com.boss.analytics.adapter.AdapterCartazVerticalMaisConteudo;
import com.boss.analytics.model.CartazVerticalModel;

import java.util.ArrayList;
import java.util.List;

public class VisuConteudoFragment extends Fragment {
    private RecyclerView recyclerMaisConteudos;
    private List<CartazVerticalModel> maisDetalhes = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_visu_conteudo, container, false);

        recyclerMaisConteudos = view.findViewById(R.id.recyclerMaisConteudos);
        //Configurar adapter
        preparaMaisConteudo();
        AdapterCartazVerticalMaisConteudo adapterContinueEstudando = new AdapterCartazVerticalMaisConteudo(maisDetalhes,getContext());

        //Configurar RecyclerView
//      LinearLayoutManager layoutManagerA = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager layoutManagerA = new GridLayoutManager(getContext(),2);
        recyclerMaisConteudos.setLayoutManager(layoutManagerA);
        recyclerMaisConteudos.setHasFixedSize(true);
        recyclerMaisConteudos.setAdapter(adapterContinueEstudando);

        return view;
    }
    public void preparaMaisConteudo(){
        CartazVerticalModel h = new CartazVerticalModel(R.drawable.cloretosinsoluveisroteiro,"Cloretos Insoluveis","O primeiro grupo de cátions é caracterizado por conter cátions que precipitam com o cloreto","");
        this.maisDetalhes.add(h);
        h = new CartazVerticalModel(R.drawable.sulfetosacidos,"Sulfetos Insoluveis em Meio Ácido","Em breve","");
        this.maisDetalhes.add(h);
        h = new CartazVerticalModel(R.drawable.sulfetosbasicos,"Sulfetos Insoluveis em Meio Básico","Em breve","");
        this.maisDetalhes.add(h);
        h = new CartazVerticalModel(R.drawable.carbonatosinsoluveisroteiro,"Carbonatos Insoluveis","Em breve","");
        this.maisDetalhes.add(h);
        h = new CartazVerticalModel(R.drawable.cationssoluveisroteiro,"Cations Soluveis","Em breve","");
        this.maisDetalhes.add(h);
        h = new CartazVerticalModel(R.drawable.cloretosinsoluveisroteiro,"Cloretos Insoluveis","Em breve","");
        this.maisDetalhes.add(h);
    }
}