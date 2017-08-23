package br.edu.up.a3ba02_playermp3tao;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerActivity extends AppCompatActivity
    implements View.OnTouchListener, MediaPlayer.OnCompletionListener
{

    ImageView btnPlay;
    ImageView btnSequencia;
    boolean isSequencial = true;
    List<Musica> listaDeMusicas = new ArrayList<>();
    int duration;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnSequencia = (ImageView) findViewById(R.id.btnSequencia);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnTouchListener(this);

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


    }

    public void alterarSequencia(View view){

        if (isSequencial == true){
            isSequencial = false;
            btnSequencia.setImageResource(R.drawable.random50px);
        } else {
            isSequencial = true;
            btnSequencia.setImageResource(R.drawable.sequencial50px);
        }

    }

    MediaPlayer player;


    public void tocarOuPausar(View view){

        novaMusica();
    }

    private void novaMusica()
    {
        if (player == null) //se o player não existe
        {
            btnPlay.setImageResource(R.drawable.pause50px);
            Musica musica = listaDeMusicas.get(musicaAtual);
            ImageView capa = (ImageView) findViewById(R.id.imgCapa);
            capa.setImageResource(musica.getCapa());
            TextView titulo = (TextView) findViewById(R.id.tituloMusica);
            titulo.setText(musica.getNome());

            player = MediaPlayer.create(this, musica.getMp3());
            player.setOnCompletionListener(this);

            duration = player.getDuration();
            seekBar.setMax(duration);

            player.start();

            atualizarBarra();

        }
        else if (player.isPlaying()) // se o player está tocando...
        {
            btnPlay.setImageResource(R.drawable.play50px);
            player.pause();
        }
        else
        { //está pausado...
            btnPlay.setImageResource(R.drawable.pause50px);
            player.start();
        }
    }

    private void atualizarBarra() {

        if (player != null && player.isPlaying()) {
            int position = player.getCurrentPosition();
            seekBar.setProgress(position);

            Runnable processo = new Runnable() {
                @Override
                public void run() {
                    atualizarBarra();
                }
            };

            new Handler().postDelayed(processo, 1000);
        }

    }

    int musicaAtual = 2;
    Random sorteador = new Random();


    public void proximaMusica(View view){

        if (isSequencial == true) {
            musicaAtual++;
            if (musicaAtual > listaDeMusicas.size() -1){
                musicaAtual = 0;
            }

        } else {
            musicaAtual = sorteador.nextInt(listaDeMusicas.size());
        }
        parar();
        novaMusica();
    }

    public void musicaAnterior(View view){
        musicaAtual--;
        if (musicaAtual < 0){
            musicaAtual = listaDeMusicas.size() -1;
        }

        parar();
        novaMusica();
    }

    public void parar(View view){
        parar();
    }

    private void parar() {
        if (player != null){
            btnPlay.setImageResource(R.drawable.play50px);
            player.stop();
            player.release(); //limpar memória;
            player = null;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        int position = seekBar.getProgress();
        player.seekTo(position);

        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        proximaMusica(null);
    }

}