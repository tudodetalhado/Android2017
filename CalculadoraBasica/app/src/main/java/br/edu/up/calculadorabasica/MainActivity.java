package br.edu.up.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Declara as variáveis (objetos);
    EditText cxNumero1Java;
    EditText cxNumero2Java;
    EditText cxResultadoJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carregar os caixas XML no Java;
        cxNumero1Java = (EditText) findViewById(R.id.cxNumero1Xml);
        cxNumero2Java = (EditText) findViewById(R.id.cxNumero2Xml);
        cxResultadoJava = (EditText) findViewById(R.id.cxResultadoXml);
    }

    int numero1;
    int numero2;
    void carregarNumeros(){
        //Pegar o texto das caixas de texto;
        String txtNumero1 = cxNumero1Java.getText().toString();
        String txtNumero2 = cxNumero2Java.getText().toString();

        //Converter para valor numérico;
        numero1 = Integer.parseInt(txtNumero1);
        numero2 = Integer.parseInt(txtNumero2);
    }

    void mostrarResultado(){
        //Converter o resultado para texto;
        String txtResultado = String.valueOf(resultado);

        //Mostrar o resultado na tela;
        cxResultadoJava.setText(txtResultado);
    }

    int resultado;
    //Funções para os cliques dos botões;
    public void cliqueSomar(View view){
        carregarNumeros();
        resultado = somar(numero1, numero2);
        mostrarResultado();
    }

    public void cliqueSutrair(View view){
        carregarNumeros();
        resultado = subtrair(numero1, numero2);
        mostrarResultado();
    }

    public void cliqueMultiplicar(View view){
        carregarNumeros();
        resultado = multiplicar(numero1, numero2);
        mostrarResultado();
    }

    public void cliqueDividir(View view){
        carregarNumeros();
        resultado = dividir(numero1, numero2);
        mostrarResultado();
    }


    // Parte lógica da calculadora;
    int somar(int n1, int n2){
        int r = n1 + n2;
        return  r;
    }
    int subtrair(int n1, int n2){
        int r2 = n1 - n2;
        return  r2;
    }
    int multiplicar(int n1, int n2){
        int r3 = n1 * n2;
        return  r3;
    }
    int dividir(int n1, int n2){
        int r4 = n1 / n2;
        return  r4;
    }

}












