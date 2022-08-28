package com.boss.analytics.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boss.analytics.R;
import com.boss.analytics.activitys.CadastroActivity;
import com.boss.analytics.activitys.PrincipalActivity;
import com.boss.analytics.configFirebase.ConfiguracaoFirebase;
import com.boss.analytics.model.UsuarioModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;


public class LoginFragment extends Fragment {
    private Button buttonEntrar, buttonCadastrar;
    private EditText txtEmail, txtSenha;
    private UsuarioModel usuario;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        iniciacao(view);

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                if(!email.isEmpty()){
                    if(!senha.isEmpty()){
                        usuario = new UsuarioModel();
                        usuario.setEmail(email);
                        usuario.setSenha(senha);
                        validarLogin(usuario);
                    }else{
                        Toast.makeText(getContext(), "Informe uma senha", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(), "Informe seu email", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                Intent intent = new Intent(getContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    private void iniciacao(View view) {
        buttonEntrar = view.findViewById(R.id.buttonEntrar);
        buttonCadastrar = view.findViewById(R.id.buttonCadastrar);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtSenha = view.findViewById(R.id.txtSenha);
    }

    public void validarLogin(UsuarioModel usuario){
        auth = ConfiguracaoFirebase.getFirebaseAutentificacao();
        auth.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirTelaPrincipal();
                }else {
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Este usuário não está cadastrado.";
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Email ou senha não correspondem a um usuário cadastrado.";
                    }catch (Exception e) {
                        e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(getContext(), excecao, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void abrirTelaPrincipal(){
        startActivity(new Intent(getContext(), PrincipalActivity.class));
        getActivity().finish();
    }
}