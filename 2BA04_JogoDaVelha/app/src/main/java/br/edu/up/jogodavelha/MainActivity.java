package br.edu.up.jogodavelha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b3 = (Button) findViewById(R.id.b3);
        b5 = (Button) findViewById(R.id.b5);
        b7 = (Button) findViewById(R.id.b7);
    }

    char jogadorDaVez = 'X';
    char[] jogadas = new char[9];

    public void cliqueB1(View view){
        jogar((Button) view, 0);
    }

    public void cliqueB2(View view){
        jogar((Button) view, 1);
    }

    public void cliqueB3(View view){
        jogar((Button) view, 2);
    }

    public void cliqueB4(View view){
        jogar((Button) view, 3);
    }

    public void cliqueB5(View view){
        jogar((Button) view, 4);
    }

    public void cliqueB6(View view){
        jogar((Button) view, 5);
    }

    public void cliqueB7(View view){
        jogar((Button) view, 6);
    }

    public void cliqueB8(View view){
        jogar((Button) view, 7);
    }

    public void cliqueB9(View view){
        jogar((Button) view, 8);
    }

    void jogar(Button btn, int posicao){
        btn.setClickable(false);
        if(jogadorDaVez == 'X'){
            btn.setText("X");
            jogadas[posicao] = 'X';
            jogadorDaVez = 'O';
        } else {
            btn.setText("O");
            jogadas[posicao] = 'O';
            jogadorDaVez = 'X';
        }

        //2, 4, 6
        if(jogadas[2] != 0 && jogadas[2] == jogadas[4] &&
                jogadas[4] == jogadas[6]){
            Toast.makeText(this,"Acabouooouuu!", Toast.LENGTH_LONG).show();
            b3.setBackgroundColor(Color.GREEN);
            b5.setBackgroundColor(Color.GREEN);
            b7.setBackgroundColor(Color.GREEN);
        }

    }
}











