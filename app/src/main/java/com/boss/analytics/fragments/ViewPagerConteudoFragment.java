package com.boss.analytics.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boss.analytics.R;
import com.boss.analytics.activitys.ShortBookActivity;
import com.boss.analytics.adapter.AdapterCartazHorizontal;
import com.boss.analytics.adapter.AdapterCartazVertical;
import com.boss.analytics.model.CartazHorizontalModel;
import com.boss.analytics.model.CartazVerticalModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class ViewPagerConteudoFragment extends Fragment {
    private FloatingActionButton fabMais, fabConteudo, fabShortBook, fabDonwload;
    //private Animation fabOpen, fabCloser, rotateFarward,rotateBackward;
    private RecyclerView recyclerNovidades, recyclerRecomendacao, recyclerContinue, recyclerCloretos;
    private List<CartazVerticalModel> listacartazVerticalModels = new ArrayList<>();
    private List<CartazHorizontalModel> listcartazHorizontalModels = new ArrayList<>();
    //private List<ContinueEstudandoModel> continueEstudando = new ArrayList<>();
    private TextView tbnShortBook;
    boolean isOpen = false;
    private AdView mAdView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_pager_conteudo, container, false);

        //Anuncio AdMob
        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //real
        //<-ca-app-pub-7571180593147491/7561773209->
        //false
        //ca-app-pub-3940256099942544/6300978111

  /*
        fabOpen = AnimationUtils.loadAnimation(getContext(),R.anim.fab_open);
        fabCloser = AnimationUtils.loadAnimation(getContext(),R.anim.fab_closer);
        rotateFarward = AnimationUtils.loadAnimation(getContext(),R.anim.rolate_forword);
        rotateBackward = AnimationUtils.loadAnimation(getContext(),R.anim.rolate_backword);

        fabConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"conteudo",Toast.LENGTH_SHORT).show();
            }
        });
        fabShortBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),VisualizacaoActivity.class);
                startActivity(intent);
            }
        });

        fabDonwload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Donwload",Toast.LENGTH_SHORT).show();

            }
        });*/
        tbnShortBook = view.findViewById(R.id.tbnShortBook);
        tbnShortBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), ShortBookActivity.class));
            }
        });


        recyclerNovidades = view.findViewById(R.id.recyclerNovidades);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerNovidades.setLayoutManager(layoutManager);
        recyclerNovidades.setHasFixedSize(true);
        //Config Adapter
        listacartazVerticalModels.clear();
        preparaCartazVertical();
        AdapterCartazVertical adapterCartazVertical = new AdapterCartazVertical(listacartazVerticalModels,getContext());
        recyclerNovidades.setAdapter(adapterCartazVertical);



        recyclerRecomendacao = view.findViewById(R.id.recyclerRecomendacao);
        LinearLayoutManager layoutManagerC = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerRecomendacao.setLayoutManager(layoutManagerC);
        //recyclerContinue.setHasFixedSize(true);
        preparaCartazHorizontal();
        AdapterCartazHorizontal adapterCartazHorizontal = new AdapterCartazHorizontal(listcartazHorizontalModels,getContext());
        recyclerRecomendacao.setAdapter(adapterCartazHorizontal);

        /*
        recyclerContinue = view.findViewById(R.id.recyclerContinue);
        LinearLayoutManager layoutManagerA = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerContinue.setLayoutManager(layoutManagerA);
        //recyclerCloretos.setHasFixedSize(true);
        preparaContinueAssistindo();
        AdapterContinueEstudando adapterContinueEstudando = new AdapterContinueEstudando(continueEstudando,getContext());
        recyclerContinue.setAdapter(adapterContinueEstudando);
        */

        return view;
    }

    //---------------------------------------------------------------------------------------------------------------------------------//

    public void preparaCartazVertical(){
        CartazVerticalModel g = new CartazVerticalModel(R.drawable.cloretosinsoluveisroteiro,"Cloretos Insolúveis","O primeiro grupo de cátions é caracterizado por conter cátions que precipitam com o cloreto","");
        this.listacartazVerticalModels.add(g);
        g = new CartazVerticalModel(R.drawable.sulfetosacidos, "Sulfetos Insolúveis em Meio Ácido","Em breve","");
        this.listacartazVerticalModels.add(g);
        g = new CartazVerticalModel(R.drawable.sulfetosbasicos,"Sulfetos Insolúveis em Meio Básico","Em breve","");
        this.listacartazVerticalModels.add(g);
        g = new CartazVerticalModel(R.drawable.carbonatosinsoluveisroteiro,"Carbonatos Insolúveis","Em breve","");
        this.listacartazVerticalModels.add(g);
        g = new CartazVerticalModel(R.drawable.cationssoluveisroteiro,"Cátions Solúveis","Em breve","");
        this.listacartazVerticalModels.add(g);
    }

    public void preparaCartazHorizontal(){
        CartazHorizontalModel h = new CartazHorizontalModel(R.drawable.determinacaodesalinidadedeamostradeaguadomar,"Determinação de salinidade de amostra de água do mar","Em breve","VvZ-b8mQCmg");
        this.listcartazHorizontalModels.add(h);
        h = new CartazHorizontalModel(R.drawable.padronizacaopelometododemohrfajansevolhard,"Padronização pelo método de Mohr, Fajans e Volhard","Em breve", "OTNFAMFkPf4&t=7s");
        this.listcartazHorizontalModels.add(h);
        h = new CartazHorizontalModel(R.drawable.joyce707x500,"Titulação por oxirredução","Em breve", "OTNFAMFkPf4&t=7s");
        this.listcartazHorizontalModels.add(h);
        h = new CartazHorizontalModel(R.drawable.anion707,"Análise de água em óleo - TOG","Em breve", "OTNFAMFkPf4&t=7s");
        this.listcartazHorizontalModels.add(h);
        h = new CartazHorizontalModel(R.drawable.aniong2707,"Titulação volumétrica,","Em breve", "OTNFAMFkPf4&t=7s");
        this.listcartazHorizontalModels.add(h);
    }

    /*public void preparaContinueAssistindo(){
        ContinueEstudandoModel h = new ContinueEstudandoModel(R.drawable.aniong5,"njnknjk","jmklnlkn");
        this.continueEstudando.add(h);
        h = new ContinueEstudandoModel(R.drawable.aniong3,"jijij","jnjknjn");
        this.continueEstudando.add(h);
        h = new ContinueEstudandoModel(R.drawable.aniong6,"klmlk","kjcndsj");
        this.continueEstudando.add(h);
        h = new ContinueEstudandoModel(R.drawable.aniong4,"jasdnjkfn","dnkjew");
        this.continueEstudando.add(h);
        h = new ContinueEstudandoModel(R.drawable.image1,"ndewjkdn","wekdmxlkewd");
        this.continueEstudando.add(h);
    }*/


    /*public void animateFab(){
        if(isOpen){
            fabMais.startAnimation(rotateFarward);
            fabConteudo.startAnimation(fabCloser);
            fabConteudo.setVisibility(View.INVISIBLE);
            fabShortBook.startAnimation(fabCloser);
            fabShortBook.setVisibility(View.INVISIBLE);
            fabDonwload.startAnimation(fabCloser);
            fabDonwload.setVisibility(View.INVISIBLE);
            isOpen = false;
        }else{
            fabMais.startAnimation(rotateBackward);
            fabDonwload.setVisibility(View.VISIBLE);
            fabDonwload.startAnimation(fabOpen);
            fabShortBook.setVisibility(View.VISIBLE);
            fabShortBook.startAnimation(fabOpen);
            fabConteudo.setVisibility(View.VISIBLE);
            fabConteudo.startAnimation(fabOpen);
            isOpen = true;
        }
    }*/

}
