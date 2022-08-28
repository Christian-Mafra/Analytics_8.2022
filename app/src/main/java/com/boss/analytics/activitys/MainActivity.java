package com.boss.analytics.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.boss.analytics.R;
import com.boss.analytics.configFirebase.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin, buttonCadastro;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        getWindow().setNavigationBarColor(ContextCompat.getColor(getApplicationContext(), R.color.cor_tema_escuro));
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.transparente));


        buttonLogin = findViewById(R.id.buttonLogin);
        buttonCadastro = findViewById(R.id.buttonCadastro);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth = ConfiguracaoFirebase.getFirebaseAutentificacao();
                if(auth.getCurrentUser() != null){
                    startActivity(new Intent(getApplicationContext(),PrincipalActivity.class));
                    finish();
                }else{
                    Intent intent = new Intent(getApplicationContext(), FragmentsActivity.class);
                    intent.putExtra("fragments",3);
                    startActivity(intent);
                }
            }
        });
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
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
