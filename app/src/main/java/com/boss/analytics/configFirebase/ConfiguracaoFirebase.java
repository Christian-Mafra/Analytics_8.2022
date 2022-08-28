package com.boss.analytics.configFirebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {
    private static FirebaseAuth auth;
    private static DatabaseReference firebase;

    //retorna a instancia do firebaseDatabase
    public static DatabaseReference getFirebaseDatabase(){
        if(firebase == null){
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return firebase;
    }

    //retorna a instancia do firebaseAuth
    public static FirebaseAuth getFirebaseAutentificacao(){
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}