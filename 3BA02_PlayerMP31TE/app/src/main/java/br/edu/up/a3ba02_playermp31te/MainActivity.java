package br.edu.up.a3ba02_playermp31te;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  List<Musica> listaDeMusicas = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BancoDeDados banco = new BancoDeDados();
    listaDeMusicas = banco.getListaDeMusicas();

    //Vetor de strings com o nome das músicas;
    String[] nomeDasMusicas = new String[listaDeMusicas.size()];
    for (int i = 0; i < listaDeMusicas.size(); i++) {
      nomeDasMusicas[i] = listaDeMusicas.get(i).getNome();
    }

    //Criar o adapter
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, nomeDasMusicas);

    //Definir o adapter no listview;
    ListView meuListView = (ListView) findViewById(R.id.listViewMusicas);
    meuListView.setAdapter(adapter);

    //Vincular o click nos itens da lista;
    meuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        //Ao clicar no item da lista coloca a position na intent para enviar ao player;
        Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
        intent.putExtra("posMusica", position);
        startActivity(intent);
      }
    });

  }

}
