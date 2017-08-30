package br.edu.up.a3ba02_playermp3tao;

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

  List<Musica> listaDeMusicas;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    BancoDeDados banco = new BancoDeDados();
    listaDeMusicas = banco.carregarListaDeMusicas();

    //Converte os objetos música para vetor de strings;
    String[] nomesDasMusicas = new String[7];
    nomesDasMusicas[0] = listaDeMusicas.get(0).getNome();
    nomesDasMusicas[1] = listaDeMusicas.get(1).getNome();
    nomesDasMusicas[2] = listaDeMusicas.get(2).getNome();
    nomesDasMusicas[3] = listaDeMusicas.get(3).getNome();
    nomesDasMusicas[4] = listaDeMusicas.get(4).getNome();
    nomesDasMusicas[5] = listaDeMusicas.get(5).getNome();
    nomesDasMusicas[6] = listaDeMusicas.get(6).getNome();


    //Criar o adapter;
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, nomesDasMusicas);

    //Carregar o adapter no listview;
    ListView listView = (ListView) findViewById(R.id.listViewMusicas);
    listView.setAdapter(adapter);

    //Vincular o onClick no listview para cada item;
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        //Toast.makeText(MainActivity.this, "Item: " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
      }
    });

    //listView.setOnItemLongClickListener();
    //listView.setOnDragListener();

  }


}
