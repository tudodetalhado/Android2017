package br.edu.up.playermp3v1tb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerActivity extends AppCompatActivity
    implements MediaPlayer.OnCompletionListener, View.OnTouchListener

{

  boolean isSequencial = true;
  ImageView btnPlay;
  ImageView capa;
  TextView txtNome;
  List<Musica> listaDeMusicas;
  SeekBar seekBar;
  BancoDeDados banco;
  int musicaAtual;
  MediaPlayer player;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);

    seekBar = (SeekBar) findViewById(R.id.seekBar);
    seekBar.setOnTouchListener(this);

    btnPlay = (ImageView) findViewById(R.id.imgPlayer);
    capa = (ImageView) findViewById(R.id.capa);
    txtNome = (TextView) findViewById(R.id.txtNome);

    banco = new BancoDeDados();
    listaDeMusicas = banco.carregarMusicas();

    //Pega a intent e dela a posição da música a ser tocada;
    Intent intent = getIntent();
    int position = intent.getIntExtra("position", 0);
    musicaAtual = position;
    tocar();

  }

  public void alterarEstilo(View view){
    ImageView btnSequencial = (ImageView) view;

    if (isSequencial == true){
      isSequencial = false;
      Collections.shuffle(listaDeMusicas);
      btnSequencial.setImageResource(R.drawable.random50px);
    } else {
      isSequencial = true;
      listaDeMusicas = banco.carregarMusicas();
      btnSequencial.setImageResource(R.drawable.sequencial50px);
    }
  }


  public void musicaAnterior(View view){
    musicaAtual--;
    if (musicaAtual < 0){
      musicaAtual = listaDeMusicas.size() -1;
    }
    parar(null);
    tocar();
  }




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

      int milisegundoDaMusica = player.getDuration();
      seekBar.setMax(milisegundoDaMusica);

      //Atribui a implementação da interface ao player.
      player.setOnCompletionListener(this);
      player.start();

      atualizarBarraDeProgresso();
    }
    else if (player.isPlaying()){
      btnPlay.setImageResource(R.drawable.play50px);
      player.pause();
    } else{
      btnPlay.setImageResource(R.drawable.pause50px);
      player.start();
    }
  }

  private void atualizarBarraDeProgresso() {

    if (player != null && player.isPlaying()) {
      int position = player.getCurrentPosition();
      seekBar.setProgress(position);
      Runnable processo = new Runnable() {
        @Override
        public void run() {
          atualizarBarraDeProgresso();
        }
      };
      new Handler().postDelayed(processo, 1000);
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

  //Este método será executado sempre
  //que acabar a execução de uma música.
  @Override
  public void onCompletion(MediaPlayer mediaPlayer) {
    proximaMusica(null);
  }

  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {

    int progessoDaBarra = seekBar.getProgress();
    player.seekTo(progessoDaBarra);

    return false;
  }
}