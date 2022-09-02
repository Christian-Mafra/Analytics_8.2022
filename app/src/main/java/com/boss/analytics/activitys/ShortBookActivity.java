package com.boss.analytics.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.boss.analytics.R;
import com.boss.analytics.adapter.AdapterShortBook;
import com.boss.analytics.model.ShortbookModel;

import java.util.ArrayList;
import java.util.List;

public class ShortBookActivity extends AppCompatActivity {
    private RecyclerView recyclerViewShortBook;
    private List<ShortbookModel> listashortbook = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_book);

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
        getWindow().setNavigationBarColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        recyclerViewShortBook = findViewById(R.id.recyclerViewShortBook);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerViewShortBook.setLayoutManager(layoutManager);
        recyclerViewShortBook.setHasFixedSize(true);
        //Config Adapter
        listashortbook.clear();
        preparaCartazVertical();
        AdapterShortBook adapterShortBook = new AdapterShortBook(listashortbook, getApplicationContext());
        recyclerViewShortBook.setAdapter(adapterShortBook);
    }

    public void preparaCartazVertical(){
        ShortbookModel g = new ShortbookModel(R.drawable.pp
                ,"Potêncial padrão de redução"
                ,"É a espontaneidade, ou a tendência de uma espécie química adquirir elétrons e, desse modo, ser reduzida.","");
        this.listashortbook.add(g);
        g = new ShortbookModel(R.drawable.sulfetosacidos
                , "Sulfetos Insolúveis em Meio Ácido"
                ,"Em breve",
                "");
        this.listashortbook.add(g);
        g = new ShortbookModel(R.drawable.sulfetosbasicos
                ,"Sulfetos Insolúveis em Meio Básico"
                ,"Em breve",
                "");
        this.listashortbook.add(g);
        g = new ShortbookModel(R.drawable.carbonatosinsoluveisroteiro
                ,"Carbonatos Insolúveis"
                ,"Em breve",
                "");
        this.listashortbook.add(g);
        g = new ShortbookModel(R.drawable.cationssoluveisroteiro
                ,"Cátions Solúveis"
                ,"Em breve",
                "");
        this.listashortbook.add(g);
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