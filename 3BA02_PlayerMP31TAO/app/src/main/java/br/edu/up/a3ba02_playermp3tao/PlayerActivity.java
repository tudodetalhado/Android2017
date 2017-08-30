package br.edu.up.a3ba02_playermp3tao;

import android.content.Intent;
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
    implements View.OnTouchListener, MediaPlayer.OnCompletionListener {

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

    BancoDeDados banco = new BancoDeDados();
    listaDeMusicas = banco.carregarListaDeMusicas();

    Intent intent = getIntent();
    int position = intent.getIntExtra("pos", 0);
    musicaAtual = position;
    novaMusica();
  }

  public void alterarSequencia(View view) {

    if (isSequencial == true) {
      isSequencial = false;
      btnSequencia.setImageResource(R.drawable.random50px);
    } else {
      isSequencial = true;
      btnSequencia.setImageResource(R.drawable.sequencial50px);
    }

  }

  MediaPlayer player;


  public void tocarOuPausar(View view) {

    novaMusica();
  }

  private void novaMusica() {
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

    } else if (player.isPlaying()) // se o player está tocando...
    {
      btnPlay.setImageResource(R.drawable.play50px);
      player.pause();
    } else { //está pausado...
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


  public void proximaMusica(View view) {

    if (isSequencial == true) {
      musicaAtual++;
      if (musicaAtual > listaDeMusicas.size() - 1) {
        musicaAtual = 0;
      }

    } else {
      musicaAtual = sorteador.nextInt(listaDeMusicas.size());
    }
    parar();
    novaMusica();
  }

  public void musicaAnterior(View view) {
    musicaAtual--;
    if (musicaAtual < 0) {
      musicaAtual = listaDeMusicas.size() - 1;
    }

    parar();
    novaMusica();
  }

  public void parar(View view) {
    parar();
  }

  private void parar() {
    if (player != null) {
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