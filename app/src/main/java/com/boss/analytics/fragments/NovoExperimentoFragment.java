package com.boss.analytics.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boss.analytics.R;
import com.boss.analytics.activitys.FragmentsActivity;
import com.boss.analytics.adapter.AdapterGruposAnions;
import com.boss.analytics.adapter.AdapterGruposCations;
import com.boss.analytics.model.GruposAnions;
import com.boss.analytics.model.GruposCations;

import java.util.ArrayList;
import java.util.List;


public class NovoExperimentoFragment extends Fragment {
    private RecyclerView recyclerViewAnaliseCations; //recyclerViewAnaliseAnions
    private List<GruposCations> gruposCations = new ArrayList<>();
  //  private List<GruposAnions> gruposAnions = new ArrayList<>();
    private AdapterGruposCations.RecyclerViewClickListner listner;
  //  private AdapterGruposAnions.RecyclerViewClickListner listner2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_experimento, container, false);


        recyclerViewAnaliseCations = view.findViewById(R.id.recyclerViewAnaliseCations);
        //Configurar adapter
        setOnClickListner();
        this.preparaGruposCations();
        AdapterGruposCations adapterGruposCations = new AdapterGruposCations(gruposCations, listner);
        recyclerViewAnaliseCations.setAdapter(adapterGruposCations);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        recyclerViewAnaliseCations.setLayoutManager(layoutManager);
        recyclerViewAnaliseCations.setHasFixedSize(true);


       /* recyclerViewAnaliseAnions = view.findViewById(R.id.recyclerViewAnaliseAnions);
        //Configurar adapter
        this.preparaGruposAnions();
        AdapterGruposAnions adapterGruposAnions = new AdapterGruposAnions(gruposAnions, listner2);
        recyclerViewAnaliseAnions.setAdapter(adapterGruposAnions);
        //recyclerViewGruposAnions.setAdapter();

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getContext(),1);
        recyclerViewAnaliseAnions.setLayoutManager(layoutManager2);
        recyclerViewAnaliseAnions.setHasFixedSize(true);
        */
        return view;
    }

    private void setOnClickListner() {
        listner = new AdapterGruposCations.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getContext(), FragmentsActivity.class);
                intent.putExtra("fragments",6);
                startActivity(intent);
            }
        };

    }

    public void preparaGruposCations(){
        GruposCations g = new GruposCations("Ag  Hg  Pb", R.drawable.cloretosinsoluveis);
        this.gruposCations.add(g);

        g = new GruposCations("Hg  Pb  Cu  Sn  Sb  Bi  Cd  As", R.drawable.sulfetosinsoluveisemmeioacido);
        this.gruposCations.add(g);

        g = new GruposCations("Fe  Mn  Co  Ni  Cr  Al  Zn", R.drawable.sulfetosinsuluveisemmeiobasico);
        this.gruposCations.add(g);

        g = new GruposCations("Ba  Ca  Sr", R.drawable.carbonatosinsoluveis);
        this.gruposCations.add(g);

        g = new GruposCations("Na  K  Mg  Amônia", R.drawable.cationssoluveis);
        this.gruposCations.add(g);
    }

    /*public void preparaGruposAnions(){
        GruposAnions g = new GruposAnions("Fluxograma de análise","", R.drawable.fluxograma);
        this.gruposAnions.add(g);

        g = new GruposAnions("Determinação do pH","Zona de predominância das espécies", R.drawable.imagemcomplementar);
        this.gruposAnions.add(g);

        g = new GruposAnions("Transferência de elétrons","Rg  Rf  Ox", R.drawable.imagemcomplementar);
        this.gruposAnions.add(g);

        g = new GruposAnions("Precipitação com Ca","Ânions do grupo volátil", R.drawable.imagemcomplementar);
        this.gruposAnions.add(g);

        g = new GruposAnions("Precipitação com Ag","", R.drawable.imagemcomplementar);
        this.gruposAnions.add(g);

        g = new GruposAnions("Fluxograma de separação","", R.drawable.imagemcomplementar);
        this.gruposAnions.add(g);

    }*/

}