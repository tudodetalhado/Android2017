package br.edu.up.playermp3v1tb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  BancoDeDados banco;
  List<Musica> listaDeMusicas;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    banco = new BancoDeDados();
    listaDeMusicas = banco.carregarMusicas();

    //Criar um vetor de strings;
    String[] nomesMusicas = new String[7];
    nomesMusicas[0] = listaDeMusicas.get(0).getNome();
    nomesMusicas[1] = listaDeMusicas.get(1).getNome();
    nomesMusicas[2] = listaDeMusicas.get(2).getNome();
    nomesMusicas[3] = listaDeMusicas.get(3).getNome();
    nomesMusicas[4] = listaDeMusicas.get(4).getNome();
    nomesMusicas[5] = listaDeMusicas.get(5).getNome();
    nomesMusicas[6] = listaDeMusicas.get(6).getNome();


    //Criar um adapter para carregar o vetor;
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, nomesMusicas);

    //Carregar o ListView do xml;
    ListView listView = (ListView) findViewById(R.id.listViewMusicas);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Toast.makeText(MainActivity.this, "Item: " + position, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, PlayerActivity.class);

        //Coloca a posição selecionada na intent para enviar para a PlayerActivity;
        intent.putExtra("position", position);
        startActivity(intent);

      }
    });



    //listView.setOnItemLongClickListener();
    //listView.setOnDragListener();


  }

  public void tocar(View view){

    Intent intent = new Intent(this, PlayerActivity.class);
    startActivity(intent);

  }
}
