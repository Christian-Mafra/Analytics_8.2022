package com.boss.analytics.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boss.analytics.R;
import com.boss.analytics.adapter.AdapterVisualizacaoConteudo;
import com.boss.analytics.model.VisualizacaoConteudoModel;

import java.util.ArrayList;
import java.util.List;

public class VisualizacaoConteudosSemelhantesragment extends Fragment {
    private RecyclerView recyclerViewVisualizacaoConteudo;
    private List<VisualizacaoConteudoModel> visualizacaoConteudoModelList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_visualizacao_conteudos_semelhantesragment, container, false);

        recyclerViewVisualizacaoConteudo = view.findViewById(R.id.RecyclerViewVisualizacaoConteudo);


        RecyclerView.LayoutManager layoutManagerA = new GridLayoutManager(getContext(), 3);
        recyclerViewVisualizacaoConteudo.setLayoutManager(layoutManagerA);
        //recyclerCloretos.setHasFixedSize(true);
        preparaVisualizacaoConteudo();
        AdapterVisualizacaoConteudo adapterVisualizacaoConteudo = new AdapterVisualizacaoConteudo(visualizacaoConteudoModelList, getContext());
        recyclerViewVisualizacaoConteudo.setAdapter(adapterVisualizacaoConteudo);

        return view;
    }

    public void preparaVisualizacaoConteudo(){
        VisualizacaoConteudoModel g = new VisualizacaoConteudoModel(R.drawable.diagramadetopo,"nlknlk","knkl","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.bill,"jknjknk","nkjnjkn","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.drew,"klkij","jjj","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.aniong2,"kjjkl","hjjkhj","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.flasks,"kljlkj","kjlkj","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.girl,"lkkljlk","fjlkejglkerf","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.teamwork,"kljlkjkl","klkljlk","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.aniong4,"lkjkljlk","cjkdflkvjl","");
        this.visualizacaoConteudoModelList.add(g);
        g = new VisualizacaoConteudoModel(R.drawable.image5,"dchdjksch","dcjdscjk","");
        this.visualizacaoConteudoModelList.add(g);
    }
}