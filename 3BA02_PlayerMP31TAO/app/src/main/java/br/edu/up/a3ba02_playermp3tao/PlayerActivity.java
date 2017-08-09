package br.edu.up.a3ba02_playermp3tao;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    int[] MP3s = {
            R.raw.anitta_bang,
            R.raw.jota_quest_na_moral,
            R.raw.pink_floyd_another_brick_in_the_wall_p2,
            R.raw.sambo_sunday_bloody_sunday,
            R.raw.talking_heads_psycho_killer,
            R.raw.the_doors_light_my_fire,
            R.raw.zeca_baleiro_disritmia
    };

    int[] capas = {
        R.drawable.anitta
    };

    MediaPlayer player;

    public void tocarOuPausar(View view){

        if (player == null) {
            ImageView capa = (ImageView) findViewById(R.id.imgCapa);
            capa.setImageResource(capas[0]);

            player = MediaPlayer.create(this, MP3s[0]);
            player.start();
        }
    }

    public void parar(View view){

        if (player != null){
            player.stop();
            player.release(); //limpar memória;
            player = null;
        }

    }
}
