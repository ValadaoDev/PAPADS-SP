package com.androidtutorialpoint.cardviewtutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renat on 21/05/2016.
 */
public class UsuarioDAO {

    public static final String NOME_TABELA = "Usuarios";
    public static final String COLUNA_ID ="id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_EMAIL ="email";
    public static final String COLUNA_SENHA = "senha";

    public static final String SCRIPT_CRIACAO_TABELA_USUARIOS = "CREATE TABLE " +
            NOME_TABELA + "(" +COLUNA_ID +" INTEGER PRIMARY KEY , " + COLUNA_NOME +" TEXT," +COLUNA_EMAIL +" TEXT," +COLUNA_SENHA +" TEXT)";

    public static final String SCRIPT_DELECAO_TABELA = "DROP TABLE IF EXISTS" +NOME_TABELA;

    private SQLiteDatabase dataBase = null;

    private static UsuarioDAO instance;

    public static UsuarioDAO getInstance(Context context){
        if(instance==null) {
            instance = new UsuarioDAO(context);
        }
        return instance;
    }
    private UsuarioDAO(Context context){
        PersistenceHelper persistenceHelper= PersistenceHelper.getInstance(context);
        dataBase = persistenceHelper.getWritableDatabase();
    }
    public void salvar(Usuario usuario){
        ContentValues values = gerarContentValuesUsuario(usuario);
        dataBase.insert(NOME_TABELA,null,values);
    }
    public List<Usuario> recuperarTodos(){
        String queryReturnAll = "SELECT * FROM" + NOME_TABELA;
        Cursor cursor = dataBase.rawQuery(queryReturnAll,null);
        List<Usuario>usuarios =construirUsuarioPorCursor(cursor);
        return usuarios;
    }

    public void deletar(Usuario usuario){
        String[] valoresParaSubstituir ={
                String.valueOf(usuario.getId())
        };
        dataBase.delete(NOME_TABELA,COLUNA_ID+ " =?",valoresParaSubstituir);
    }
    public void editar(Usuario usuario){
        ContentValues valores = gerarContentValuesUsuario(usuario);
        String[] valoresParaSubstituir ={
                String.valueOf(usuario.getId())
        };
    }
    public void fecharConexao(){
        if(dataBase !=null && dataBase.isOpen())
            dataBase.close();
    }
    private List<Usuario> construirUsuarioPorCursor(Cursor cursor){
        List<Usuario>usuarios = new ArrayList<Usuario>();
        if(cursor == null)
            return usuarios;
        try{
            if(cursor.moveToFirst()){
                do{
                    int indexID = cursor.getColumnIndex(COLUNA_ID);
                    int indexNome = cursor.getColumnIndex(COLUNA_NOME);
                    int indexEmail = cursor.getColumnIndex(COLUNA_EMAIL);
                    int indexSenha = cursor.getColumnIndex(COLUNA_SENHA);

                    int id = cursor.getInt(indexID);
                    String nome = cursor.getString(indexNome);
                    String email = cursor.getString(indexEmail);
                    String senha = cursor.getString(indexSenha);

                    Usuario usuario = new Usuario(id,nome,email,senha);
                    usuarios.add(usuario);

                }while(cursor.moveToNext());
            }
        }finally{
            cursor.close();
        }
        return usuarios;
    }
    private ContentValues gerarContentValuesUsuario(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put(COLUNA_NOME, usuario.getNome());
        values.put(COLUNA_EMAIL,usuario.getEmail());
        values.put(COLUNA_SENHA,usuario.getSenha());

        return values;
    }
}