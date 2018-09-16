package br.eaj.tuany.mybooksqlite;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import modelo.BancoHelper;
import modelo.Livro;

public class CadastrarBooks extends AppCompatActivity {

    private EditText titulo;
    private EditText autor;
    private EditText ano;
    private RatingBar nota;
    private Button salvar;
    private Button cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_books);
        titulo = findViewById(R.id.editTITULO);
        autor = findViewById(R.id.editAUTOR);
        ano = findViewById(R.id.editANO);
        nota = findViewById(R.id.ratingNota);
        salvar = findViewById(R.id.bSalvar);
        cancelar = findViewById(R.id.bCancelar);

    }

    public  void  salvar(View v) {
        BancoHelper db = new BancoHelper(this);
        Livro livro= new Livro(titulo.getText().toString(), autor.getText().toString(), Integer.parseInt(ano.getText().toString()), Float.parseFloat(String.valueOf(nota.getRating())));

        //Log.i("BANANINHA", livro.toString());

        db.save(livro);
        Log.i("BANANINHA", "SALVO NO BD");
        setResult(RESULT_OK);
        finish();
    }
    public  void  cancelar(View v){
        Log.i("BANANINHA", "OPERACAO CANCELADA");
        finish();
        setResult(RESULT_CANCELED);
    }

}
