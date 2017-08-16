package br.edu.up.a3ba02_playermp31te;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PlayerActivity extends AppCompatActivity {

    ImageView btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        btnPlay = (ImageView) findViewById(R.id.btnPlay);
    }

    MediaPlayer player;

    int[] MP3s = {
            R.raw.anitta_bang,
            R.raw.jota_quest_na_moral,
            R.raw.pink_floyd_another_brick_in_the_wall_p2,
            R.raw.sambo_sunday_bloody_sunday,
            R.raw.talking_heads_psycho_killer,
            R.raw.the_doors_light_my_fire,
            R.raw.zeca_baleiro_disritmia
    };

    int musicaAtual = 4;

    public void proximaMusica(View view) {

        musicaAtual = musicaAtual + 1;
        if (musicaAtual > MP3s.length - 1) {
            musicaAtual = 0;
        }
        parar();
        tocar();
    }

    public void musicaAnterior(View view) {
        musicaAtual = musicaAtual - 1;
        if (musicaAtual < 0) {
            musicaAtual = MP3s.length - 1;
        }

        parar();
        tocar();
    }

    public void tocarOuPausar(View view){
        tocar();
    }

    public void parar(View view){
        parar();
    }

    public void tocar() {
        if (player == null) { //se o player não está tocando ou não existe
            btnPlay.setImageResource(R.drawable.pause50px);
            player = MediaPlayer.create(this, MP3s[musicaAtual]);
            player.start();
        } else if (player.isPlaying()) { //se está tocando
            btnPlay.setImageResource(R.drawable.play50px);
            player.pause();
        } else {
            btnPlay.setImageResource(R.drawable.pause50px);
            player.start();
        }
    }

    public void parar() {
        if (player != null && player.isPlaying()) {
            player.stop();
            player.release(); //liberar memória
            player = null;
        }
    }

}
