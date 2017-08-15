package br.edu.up.playermp3v1tb;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {


    boolean isSequencial = true;
    ImageView btnPlay;
    ImageView capa;
    TextView txtNome;
    List<Musica> listaDeMusicas = new ArrayList<>();

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

         btnPlay = (ImageView) findViewById(R.id.imgPlayer);
         capa = (ImageView) findViewById(R.id.capa);
         txtNome = (TextView) findViewById(R.id.txtNome);
         carregarMusicas();
    }

    public void alterarEstilo(View view){
        ImageView btnSequencial = (ImageView) view;

        if (isSequencial == true){
            isSequencial = false;
            Collections.shuffle(listaDeMusicas);
            btnSequencial.setImageResource(R.drawable.random50px);
        } else {
            isSequencial = true;
            listaDeMusicas = carregarMusicas();
            btnSequencial.setImageResource(R.drawable.sequencial50px);
        }
    }

    private List<Musica> carregarMusicas() {

        Musica m1 = new Musica();
        m1.setId(1);
        m1.setBanda("Anitta");
        m1.setNome("Bang");
        m1.setCapa(R.drawable.anitta);
        m1.setMp3(R.raw.anitta_bang);

        Musica m2 = new Musica();
        m2.setId(2);
        m2.setBanda("Jota Quest");
        m2.setNome("Na moral");
        m2.setCapa(R.drawable.jota_quest);
        m2.setMp3(R.raw.jota_quest_na_moral);

        Musica m3 = new Musica();
        m3.setId(3);
        m3.setBanda("Pink Floyd");
        m3.setNome("Another Brick in the Wall");
        m3.setCapa(R.drawable.pink_floyd);
        m3.setMp3(R.raw.pink_floyd_another_brick_in_the_wall_p2);

        Musica m4 = new Musica();
        m4.setId(4);
        m4.setBanda("Sambô");
        m4.setNome("Sunday bloody sunday");
        m4.setCapa(R.drawable.sambo);
        m4.setMp3(R.raw.sambo_sunday_bloody_sunday);

        Musica m5 = new Musica();
        m5.setId(5);
        m5.setBanda("Talking Heads");
        m5.setNome("Psycho Killer");
        m5.setCapa(R.drawable.talking_heads);
        m5.setMp3(R.raw.talking_heads_psycho_killer);

        Musica m6 = new Musica();
        m6.setId(6);
        m6.setBanda("The Doors");
        m6.setNome("Light my fire");
        m6.setCapa(R.drawable.the_doors);
        m6.setMp3(R.raw.the_doors_light_my_fire);

        Musica m7 = new Musica();
        m7.setId(7);
        m7.setBanda("Zeca Baleiro");
        m7.setNome("Disritimia");
        m7.setCapa(R.drawable.zeca_baleiro);
        m7.setMp3(R.raw.zeca_baleiro_disritmia);

        listaDeMusicas.add(m1);
        listaDeMusicas.add(m2);
        listaDeMusicas.add(m3);
        listaDeMusicas.add(m4);
        listaDeMusicas.add(m5);
        listaDeMusicas.add(m6);
        listaDeMusicas.add(m7);

        return  listaDeMusicas;
    }


    public void musicaAnterior(View view){
        musicaAtual--;
        if (musicaAtual < 0){
            musicaAtual = listaDeMusicas.size() -1;
        }
        parar(null);
        tocar();
    }


    int musicaAtual = 3;
    MediaPlayer player;

    public void tocarOuPausar(View view)
    {
        tocar();
    }

    public void tocar()
    {
        if (player == null)
        {
            Musica musica = listaDeMusicas.get(musicaAtual);
            capa.setImageResource(musica.getCapa());
            txtNome.setText(musica.getNome());
            btnPlay.setImageResource(R.drawable.pause50px);
            player = MediaPlayer.create(this, musica.getMp3());
            player.start();
        }
        else if (player.isPlaying()){
            btnPlay.setImageResource(R.drawable.play50px);
            player.pause();
        } else{
            btnPlay.setImageResource(R.drawable.pause50px);
            player.start();
        }
    }

    public void proximaMusica(View view){
        musicaAtual++;
        if (musicaAtual >= listaDeMusicas.size())
        {
            musicaAtual = 0;
        }
        parar(null);
        tocar();
    }

    public void parar(View view){
        if (player != null)
        {
            player.stop();
            player.release();
            player = null;
        }

    }
}