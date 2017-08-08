package br.edu.up.a3ba02_playermp3tao;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        MediaPlayer player = MediaPlayer.create(this, R.raw.sambo_sunday_bloody_sunday);
        player.start();

    }
}
