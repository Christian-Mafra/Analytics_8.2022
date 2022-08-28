package com.boss.analytics.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.boss.analytics.R;
import com.boss.analytics.adapter.AdapterGruposAnions;
import com.boss.analytics.adapter.AdapterGruposCations;
import com.boss.analytics.model.GruposAnions;
import com.boss.analytics.model.GruposCations;

import java.util.ArrayList;
import java.util.List;

public class NovoExperimentoActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAnaliseCations, recyclerViewAnaliseAnions;
    private List<GruposCations> gruposCations = new ArrayList<>();
    //private List<GruposAnions> gruposAnions = new ArrayList<>();
    private AdapterGruposCations.RecyclerViewClickListner listner;
    //private AdapterGruposAnions.RecyclerViewClickListner listner2;
    private ImageView img;
    private TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_experimento);

        if(Build.VERSION.SDK_INT>=19 && Build.VERSION.SDK_INT<2){
            setWindowsFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if(Build.VERSION.SDK_INT>=19){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if(Build.VERSION.SDK_INT<2){
            setWindowsFlag(this,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.transparente));
        getWindow().setNavigationBarColor(ContextCompat.getColor(getApplicationContext(),R.color.cor_tema_escuro));


        img = findViewById(R.id.imageView2);
        txtTitulo = findViewById(R.id.txtTitExp);

        img.setImageResource(getIntent().getIntExtra("foto",0));
        txtTitulo.setText(getIntent().getStringExtra("titulo"));

        recyclerViewAnaliseCations = findViewById(R.id.recyclerViewAnaliseCations);
        //Configurar adapter
        setOnClickListner();
        this.preparaGruposCations();
        AdapterGruposCations adapterGruposCations = new AdapterGruposCations(gruposCations, listner);
        recyclerViewAnaliseCations.setAdapter(adapterGruposCations);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerViewAnaliseCations.setLayoutManager(layoutManager);
        recyclerViewAnaliseCations.setHasFixedSize(true);


        /*recyclerViewAnaliseAnions = findViewById(R.id.recyclerViewAnaliseAnions);
        //Configurar adapter
        this.preparaGruposAnions();
        AdapterGruposAnions adapterGruposAnions = new AdapterGruposAnions(gruposAnions, listner2);
        recyclerViewAnaliseAnions.setAdapter(adapterGruposAnions);
        //recyclerViewGruposAnions.setAdapter();

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getApplicationContext(),1);
        recyclerViewAnaliseAnions.setLayoutManager(layoutManager2);
        recyclerViewAnaliseAnions.setHasFixedSize(true);
        */
    }

    private void setOnClickListner() {
        listner = new AdapterGruposCations.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), FragmentsActivity.class);
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


    private static void setWindowsFlag(Activity activity, final int Bits, Boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParms = win.getAttributes();
        if(on){
            winParms.flags |= Bits;
        }else{
            winParms.flags &= ~Bits;
        }
        win.setAttributes(winParms);
    }
}