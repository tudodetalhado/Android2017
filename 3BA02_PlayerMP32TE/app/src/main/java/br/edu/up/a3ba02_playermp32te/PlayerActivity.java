package br.edu.up.a3ba02_playermp32te;

import android.content.Intent;
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

public class PlayerActivity extends AppCompatActivity

    implements MediaPlayer.OnCompletionListener,
    View.OnTouchListener

{

  ImageView btnPlay;
  ImageView capa;
  TextView titulo;
  List<Musica> listaDeMusicas = new ArrayList<>();
  SeekBar seekBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player);

    btnPlay = (ImageView) findViewById(R.id.btnPlay);
    capa = (ImageView) findViewById(R.id.imgCapa);
    titulo = (TextView) findViewById(R.id.tituloMusica);
    seekBar = (SeekBar) findViewById(R.id.seekBar);
    seekBar.setOnTouchListener(this);

    BancoDeDados banco = new BancoDeDados();
    listaDeMusicas = banco.getListaDeMusicas();

    Intent intent = getIntent();
    musicaAtual = intent.getIntExtra("musPosition", 0);
    tocar();
  }
  int musicaAtual;

  MediaPlayer player;



  public void proximaMusica(View view) {
    musicaAtual = musicaAtual + 1;
    if (musicaAtual > listaDeMusicas.size() - 1) {
      musicaAtual = 0;
    }

    parar();
    tocar();
  }

  public void musicaAnterior(View view) {
    musicaAtual = musicaAtual - 1;

    if (musicaAtual < 0) {
      musicaAtual = listaDeMusicas.size() - 1;
    }

    parar();
    tocar();
  }

  public void tocar() {
    if (player == null) { //Se o player não existe

      Musica musica = listaDeMusicas.get(musicaAtual);
      capa.setImageResource(musica.getCapa());
      titulo.setText(musica.getNome());
      btnPlay.setImageResource(R.drawable.pause50px);
      player = MediaPlayer.create(this, musica.getMp3());

      int duration = player.getDuration();
      seekBar.setMax(duration);

      player.setOnCompletionListener(this);

      player.start();

      atualizarBarra();


    } else if (player.isPlaying()) { //Se o player está tocando.
      btnPlay.setImageResource(R.drawable.play50px);
      player.pause();
    } else { //volta a tocar
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

  public void tocarOuPausar(View view) {
    tocar();
  }

  public void parar(View view) {
    parar();
  }

  public void parar() {
    if (player != null) {
      player.stop();
      player.release(); //limpar memória
      player = null;
    }
  }

  @Override
  public void onCompletion(MediaPlayer mediaPlayer) {
    proximaMusica(null);
  }

  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {

    int position = seekBar.getProgress();
    player.seekTo(position);

    return false;
  }

  @Override
  protected void onStop() {
    super.onStop();
    parar();
  }
}
