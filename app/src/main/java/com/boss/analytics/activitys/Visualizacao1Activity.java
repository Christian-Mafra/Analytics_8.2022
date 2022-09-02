package com.boss.analytics.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.boss.analytics.R;
import com.boss.analytics.fragments.VisuConteudoFragment;
import com.boss.analytics.fragments.VisuDetalhesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.Objects;

public class Visualizacao1Activity extends AppCompatActivity {
    private ImageView img;
    private TextView txtNomeConteudo;
    private TextView txtDescConteudo;
    private Button btnVamosLa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao1);

        img = findViewById(R.id.imgVisualizacao);
        txtNomeConteudo = findViewById(R.id.txtNomeConteudo);
        txtDescConteudo = findViewById(R.id.txtDescConteudo);

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

        //Recebendo imagem
        img.setImageResource(getIntent().getIntExtra("foto",0));
        txtNomeConteudo.setText(getIntent().getStringExtra("nome"));
        txtDescConteudo.setText(getIntent().getStringExtra("desc"));

        //SmartTabLayout

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Mais Conteúdos", VisuConteudoFragment.class)
                .add("Detalhes", VisuDetalhesFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        btnVamosLa = findViewById(R.id.btnVamosLa);
        btnVamosLa.setOnClickListener(new View.OnClickListener() {
            private String idVideo = getIntent().getStringExtra("idVideo");
            private String a1 = getIntent().getStringExtra("desc");
            private String a2 = "Em breve";
            @Override
            public void onClick(View v) {
                if(!Objects.equals(idVideo, "")){
                    Intent intent = new Intent(getApplicationContext(),YoutubeActivity.class);
                    intent.putExtra("idVideo", idVideo);
                    startActivity(intent);
                }
                else {
                    if (!a1.equals(a2)) {
                        Intent intent = new Intent(getApplicationContext(), PDFActivity.class);
                        startActivity(intent);
                    } else {
                        finish();
                        Intent intent = new Intent(getApplicationContext(), FragmentsActivity.class);
                        intent.putExtra("fragments", 8);
                        startActivity(intent);
                    }
                }
            }
        });
    }
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