package com.boss.analytics.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.boss.analytics.R;
import com.boss.analytics.fragments.PerfilFragment;
import com.boss.analytics.fragments.ViewPagerConteudoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PrincipalActivity extends AppCompatActivity {
    BottomNavigationView button_navigation_view;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

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
        getWindow().setNavigationBarColor(ContextCompat.getColor(getApplicationContext(), R.color.cor_tema_claro));
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.transparente));

        getSupportFragmentManager().beginTransaction().replace(R.id.frama_principal, new ViewPagerConteudoFragment()).commit();
        //  button_navigation_view.setSelectedItemId(R.id.nav_conteudo);

        button_navigation_view = findViewById(R.id.button_navigation_view);
        button_navigation_view.setBackground(null);
        button_navigation_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){

                    case R.id.nav_conteudo:
                        fragment = new ViewPagerConteudoFragment();
                        break;

                    case R.id.nav_perfil:
                        fragment = new PerfilFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frama_principal,fragment).commit();
                return true;
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FragmentsActivity.class);
                intent.putExtra("fragments",2);
                startActivity(intent);
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