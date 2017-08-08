package br.edu.up.conversor;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Declaração das variáveis (objetos) fora das funções;
    EditText txtEntrada1;
    EditText txtEntrada2;
    EditText txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carregar os textos do XML;
        txtEntrada1 = (EditText) findViewById(R.id.txtEntrada1);
        txtEntrada2 = (EditText) findViewById(R.id.txtEntrada2);
        txtResultado = (EditText) findViewById(R.id.txtResultado);
    }

    public void somarNumeros(View view){

        //Recupera os textos das caixas de texto;
        String texto1 = txtEntrada1.getText().toString();
        String texto2 = txtEntrada2.getText().toString();

        //Converte os textos para número;
        int numero1 = Integer.parseInt(texto1);
        int numero2 = Integer.parseInt(texto2);

        //Calcula a soma;
        int resultado = numero1 + numero2;

        //Converte o número para texto;
        String retorno  = String.valueOf(resultado);

        //Define o valor na caixa de texto resultado;
        txtResultado.setText(retorno);
    }
}
