package com.androidtutorialpoint.cardviewtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by renat on 21/05/2016.
 */
public class Cadastro extends Activity {


    private EditText nomeEt;
    private EditText senhaEt;
    private EditText emailEt;
    private Button salvarBt;


    @Override
    protected void onCreate(Bundle instanceSavedState) {
        super.onCreate(instanceSavedState);
        setContentView(R.layout.cadastro);
        nomeEt = (EditText) findViewById(R.id.nome);
        senhaEt = (EditText)findViewById(R.id.email);
        emailEt=(EditText)findViewById(R.id.senha);

    }

    public void salvarUsuario(View view) {


        String nome = nomeEt.getText().toString();
        String email = emailEt.getText().toString();
        String senha = senhaEt.getText().toString();

        Usuario user = new Usuario(0, nome, email, senha);

        UsuarioDAO userDao = UsuarioDAO.getInstance(getBaseContext());
        userDao.salvar(user);


        Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
    }


    public void voltar(View view) {
        startActivity(new Intent(this, Login.class));
    }


}

