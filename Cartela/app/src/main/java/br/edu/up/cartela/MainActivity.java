package br.edu.up.cartela;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random sorteador = new Random();
        GridLayout cartela = (GridLayout) findViewById(R.id.cartela);

         for (int x = 0; x < cartela.getColumnCount(); x++)
        {
            for(int y = 0; y < cartela.getRowCount(); y++)
            {
                Button b = (Button) getLayoutInflater().inflate(R.layout.btn_base,cartela);
                String txt = String.valueOf(sorteador.nextInt(100));
                b.setText(txt);
                cartela.addView(b);
            }
        }

    }
}
