package br.eaj.tuany.mybooksqlite;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button cadastrar, listar;
    private static final int CADASTRO = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cadastrar = findViewById(R.id.bCadastrar);
        listar = findViewById(R.id.bListar);
    }
    public  void botaoCadastrar(View v){// botao que cadastra novo livro
        Intent i = new Intent(this, CadastrarBooks.class);
        startActivityForResult(i,CADASTRO);
    }
    public  void botaoListar(View v){//Listar Livros
        Log.i("BANANINHA", "ENTROU NA TELA DE LISTAR LIVROS");
        Intent i = new Intent(this, ListarBooks.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        View v = findViewById(R.id.telacadastrar);
        if(resultCode==RESULT_OK) {
            //Toast.makeText(this, "Cadastro Realizado", Toast.LENGTH_SHORT).show();
            Snackbar  snackbar = Snackbar.make((View) v.getParent(), "Livro Cadastrado com Sucesso", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }else if (resultCode==RESULT_CANCELED){
            //Toast.makeText(this, "Operação Cancelada", Toast.LENGTH_SHORT).show();
            Snackbar  snackbar = Snackbar.make((View) v.getParent(), "Operação Cancelada", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
    }

}
