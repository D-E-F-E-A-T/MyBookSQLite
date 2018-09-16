package br.eaj.tuany.mybooksqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
                Toast.makeText(this, "Primeiro Registro", Toast.LENGTH_SHORT).show();
            }else{
                anterior.setClickable(true);
            }
            if(indice<tamanholista-1){
                proximo.setClickable(true);
            }else{
                proximo.setClickable(false);
                Toast.makeText(this, "Último Registro", Toast.LENGTH_SHORT).show();
            }

            Log.i("BANANINHA", ""+indice);
            titulo.setText(listarlivro.get(indice).getTitulo().toString());
            autor.setText(listarlivro.get(indice).getAutor().toString());
            ano.setText(String.valueOf(listarlivro.get(indice).getAno()).toString());
            nota.setText(String.valueOf(listarlivro.get(indice).getNota()).toString());

        }else{
            anterior.setClickable(false);
            proximo.setClickable(false);
            Toast.makeText(this, "Nenhum Registro Encontrado", Toast.LENGTH_SHORT).show();

        }
    }
    public void anterior(View v){
       indice--;
       listadelivros();
       /*if(indice==0){
           Snackbar sb = Snackbar.make((View) v.getParent(), "Primeiro Registro",Snackbar.LENGTH_LONG);
           sb.show();
       }*/

    }

    public void proximo(View v) {
        indice++;
        listadelivros();
    }


}
