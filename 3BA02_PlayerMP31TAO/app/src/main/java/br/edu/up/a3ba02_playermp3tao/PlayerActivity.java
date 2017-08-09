package br.edu.up.a3ba02_playermp3tao;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }



    int[] capas = {
            R.drawable.anitta,
            R.drawable.jota_quest,
            R.drawable.pink_floyd,
            R.drawable.sambo,
            R.drawable.talking_heads,
            R.drawable.the_doors,
            R.drawable.zeca_baleiro
    };

    int[] MP3s = {
            R.raw.anitta_bang,
            R.raw.jota_quest_na_moral,
            R.raw.pink_floyd_another_brick_in_the_wall_p2,
            R.raw.sambo_sunday_bloody_sunday,
            R.raw.talking_heads_psycho_killer,
            R.raw.the_doors_light_my_fire,
            R.raw.zeca_baleiro_disritmia
    };

    String[] musicas = {
            "Bang",
            "Na moral",
            "Another brick in the wall",
            "Sunday bloody sunday",
            "Psycho killer",
            "Light my fire",
            "Disritimia"
    };

    MediaPlayer player;
    int musicaAtual = 2;

    public void tocarOuPausar(View view){

        novaMusica();
    }

    private void novaMusica() {
        if (player == null) {
            ImageView capa = (ImageView) findViewById(R.id.imgCapa);
            capa.setImageResource(capas[musicaAtual]);

            TextView titulo = (TextView) findViewById(R.id.tituloMusica);
            titulo.setText(musicas[musicaAtual]);

            player = MediaPlayer.create(this, MP3s[musicaAtual]);
            player.start();
        }
    }

    public void proximaMusica(View view){
        musicaAtual += musicaAtual;
        parar();
        novaMusica();
    }


    public void musicaAnterior(View view){
        musicaAtual -= musicaAtual;
        parar();
        novaMusica();
    }



    public void parar(View view){

        parar();

    }

    private void parar() {
        if (player != null){
            player.stop();
            player.release(); //limpar memória;
            player = null;
        }
    }
}
