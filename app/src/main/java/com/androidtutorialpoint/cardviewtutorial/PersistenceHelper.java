package com.androidtutorialpoint.cardviewtutorial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by renat on 21/05/2016.
 */
public class PersistenceHelper extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "Usuarios";
    public static final int VERSAO =1;

    private static PersistenceHelper instance;

    private PersistenceHelper(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }
    public static PersistenceHelper getInstance(Context context){
        if(instance == null)
            instance = new PersistenceHelper(context);

        return instance;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(UsuarioDAO.SCRIPT_CRIACAO_TABELA_USUARIOS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(UsuarioDAO.SCRIPT_DELECAO_TABELA);
        onCreate(db);
    }
}
