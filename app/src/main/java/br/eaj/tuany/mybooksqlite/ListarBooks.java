package br.eaj.tuany.mybooksqlite;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import modelo.BancoHelper;
import modelo.Livro;
import modelo.LivroContrato;

public class ListarBooks extends AppCompatActivity {
    private TextView titulo;
    private TextView autor;
    private TextView ano;
    private TextView nota;
    private Button anterior;
    private Button proximo;
    private int  tamanholista=0, indice=0;
    private List<Livro> listarlivro ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_books);

        BancoHelper bancoHelper = new BancoHelper(this);

        titulo = findViewById(R.id.textVisuTitulo);
        autor = findViewById(R.id.textVisuAutor);
        ano = findViewById(R.id.textVisuAno);
        nota = findViewById(R.id.textVisuNota);
        anterior = findViewById(R.id.bAnterior);
        proximo = findViewById(R.id.bProximo);

        listarlivro = bancoHelper.findAll();
        listadelivros();
    }


    public void listadelivros(){
        if(!listarlivro.isEmpty()){
            tamanholista = listarlivro.size();
            if (indice ==0){
                anterior.setClickable(false);
            }else{
                anterior.setClickable(true);
            }
            if(indice<tamanholista-1){
                proximo.setClickable(true);
            }else{
                proximo.setClickable(false);
            }

            Log.i("BANANINHA", ""+indice);
            titulo.setText(listarlivro.get(indice).getTitulo().toString());

            autor.setText(listarlivro.get(indice).getAutor().toString());
            ano.setText(String.valueOf(listarlivro.get(indice).getAno()));
            nota.setText(String.valueOf(listarlivro.get(indice).getNota()).toString());
           //Livro livro = listarlivro.get(indice);
            /*titulo.setText(listarlivro.get(indice).getTitulo());
            autor.setText(listarlivro.get(indice).getAutor());
            ano.setText(listarlivro.get(indice).getAno());
            nota.setText(String.valueOf(listarlivro.get(indice).getNota()));*/
        }else{
            anterior.setClickable(false);
            proximo.setClickable(false);
        }
    }
    public void anterior(View v){
       indice--;
       listadelivros();
       if(indice==0){
           Snackbar sb = Snackbar.make((View) v.getParent(), "Primeiro Registro",Snackbar.LENGTH_LONG);
           sb.show();
       }

    }

    public void proximo(View v) {
        indice++;
        listadelivros();
        ///Log.i("BANANINHA", " primeiro livro: " + LivroContrato.LivroEntry._COUNT);

    }

    /*private void  atualizar(int i){
        Log.i("BANANINHA", "NO ATUALIZAR");

        titulo.setText(listarlivro.get(i).getTitulo());
        autor.setText(listarlivro.get(i).getAutor());
        ano.setText(listarlivro.get(i).getAno());
        nota.setText(String.valueOf(listarlivro.get(i).getNota()));
    }*/


    /*private void  atualizar(int i){
        titulo.setText(listarlivro.get(i).getTitulo());
        autor.setText(listarlivro.get(i).getAutor());
        ano.setText(listarlivro.get(i).getAno());
        nota.setText(String.valueOf(listarlivro.get(i).getNota()));
    }
    public void anterior(View v){
        if(livroatual == 0){
            Snackbar snackbar = Snackbar.make((View) v.getParent(), "Primeiro registro", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }else{
            atualizar(livroatual - 1);
            livroatual--;
        }
    }

    public void proximo(View v){
        if(livroatual == listarlivro.size()-1){
            Snackbar snackbar = Snackbar.make((View) v.getParent(), "Último registro", Snackbar.LENGTH_SHORT);
            snackbar.show();
        }else{
            atualizar(livroatual + 1);
            livroatual++;
        }
    }*/
}
