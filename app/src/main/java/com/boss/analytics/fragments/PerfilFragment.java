package com.boss.analytics.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.boss.analytics.R;
import com.boss.analytics.activitys.DownloadActivity;
import com.boss.analytics.activitys.FragmentsActivity;
import com.boss.analytics.activitys.MainActivity;
import com.boss.analytics.configFirebase.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;


public class PerfilFragment extends Fragment {
    private Button button5, button7, button8;
    private FirebaseAuth auth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        iniciacao(view);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FragmentsActivity.class);
                intent.putExtra("fragments",7);
                getContext().startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("Sair do Analytics");
                dialog.setMessage(null);
                dialog.setCancelable(false);
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        auth = ConfiguracaoFirebase.getFirebaseAutentificacao();
                        auth.signOut();
                        getActivity().finish();
                        Intent intent = new Intent(getContext(), LoginOuCadastroFragment.class);
                        getContext().startActivity(new Intent(getContext(), MainActivity.class));
                    }
                });
                dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                dialog.create();
                dialog.show();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DownloadActivity.class);
                getContext().startActivity(intent);
            }
        });


        return view;
    }
    public void iniciacao(View view){
        button5 = view.findViewById(R.id.button5);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);

    }
}