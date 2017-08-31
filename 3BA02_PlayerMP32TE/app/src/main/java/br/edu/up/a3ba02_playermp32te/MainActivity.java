package br.edu.up.a3ba02_playermp32te;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  List<Musica> listaDeMusicas = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Carrega as músicas do banco de dados;
    BancoDeDados banco = new BancoDeDados();
    listaDeMusicas = banco.getListaDeMusicas();

    listaDeMusicas.get(0);

    //Converte as músicas para um vetor de Strings;
    String[] nomeDasMusicas = new String[listaDeMusicas.size()];
    for(int i = 0; i < listaDeMusicas.size(); i++){
      nomeDasMusicas[i] = listaDeMusicas.get(i).getNome();
    }

    //Criar o adapter para colocar as múscas no listview;
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, nomeDasMusicas);

    //Carrega o listview do Xml no Java e define o adapter;
    ListView listView = (ListView) findViewById(R.id.listViewMusicas);
    listView.setAdapter(adapter);

    //Vincular o clique do item;
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Toast.makeText(MainActivity.this, "Item: " + position, Toast.LENGTH_LONG ).show();

        Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
        intent.putExtra("musPosition", position);
        startActivity(intent);

      }
    });
    //listView.setOnItemLongClickListener();
    //listView.setOnDragListener();
  }


}
