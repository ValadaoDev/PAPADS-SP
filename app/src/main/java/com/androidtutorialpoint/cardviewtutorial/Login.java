package com.androidtutorialpoint.cardviewtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by renat on 21/05/2016.
 */
public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.login);



    }
    public void cadastrar(View view){
        startActivity(new Intent(this,Cadastro.class));
    }

    public void logar(View view){



        startActivity(new Intent(this, MainActivity.class));

    }


}