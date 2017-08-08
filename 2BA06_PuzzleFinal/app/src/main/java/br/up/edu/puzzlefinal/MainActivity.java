package br.up.edu.puzzlefinal;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener {


    //Button[] vetorDeBotoes = new Button[9];
    Integer[] IDsImagens = {
            R.drawable.lion_face_01,
            R.drawable.lion_face_02,
            R.drawable.lion_face_03,
            R.drawable.lion_face_04,
            R.drawable.lion_face_05,
            R.drawable.lion_face_06,
            R.drawable.lion_face_07,
            R.drawable.lion_face_08,
            R.drawable.lion_face_09
    };

    ArrayList<Button> listaDeBotoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        listaDeBotoes.add(btn1);

        Button btn2 = (Button) findViewById(R.id.btn2);
        listaDeBotoes.add(btn2);

        Button btn3 = (Button) findViewById(R.id.btn3);
        listaDeBotoes.add(btn3);

        Button btn4 = (Button) findViewById(R.id.btn4);
        listaDeBotoes.add(btn4);

        Button btn5 = (Button) findViewById(R.id.btn5);
        listaDeBotoes.add(btn5);

        Button btn6 = (Button) findViewById(R.id.btn6);
        listaDeBotoes.add(btn6);

        Button btn7 = (Button) findViewById(R.id.btn7);
        listaDeBotoes.add(btn7);

        Button btn8 = (Button) findViewById(R.id.btn8);
        listaDeBotoes.add(btn8);

        Button btn9 = (Button) findViewById(R.id.btn9);
        listaDeBotoes.add(btn9);
    }

    public void embaralhar(View view){

        //Collections.shuffle(listaDeBotoes);

        List<Integer> listaDeIDs = Arrays.asList(IDsImagens);
        Collections.shuffle(listaDeIDs);

        for(int i = 0; i < listaDeBotoes.size(); i++){
            Button btn = listaDeBotoes.get(i);
            btn.setBackgroundResource(listaDeIDs.get(i));
        }
    }

    int acao;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            acao = MotionEvent.ACTION_DOWN;
            return true;
        }

        return false;
    }
}






//
//
//    //Button btn1 = (Button) findViewById(R.id.btn1);
//    Button btn1 = listaDeBotoes.get(0);
//        btn1.setBackgroundResource(R.drawable.lion_face_02);
//
//                //Button btn2 = (Button) findViewById(R.id.btn2);
//                Button btn2 = listaDeBotoes.get(1);
//                btn2.setBackgroundResource(R.drawable.lion_face_01);






















//    float posX;
//    float posY;

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (event.getActionMasked()) {
//
//            case MotionEvent.ACTION_DOWN:
//                posX = v.getX() - event.getX();
//                posY = v.getY() - event.getY();
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                v.setX(event.getX() + posX);
//                v.setY(event.getY() + posY);
//                break;
//
//            default:
//                return false;
//        }
//        return true;
//    }

//    @Override
//    public boolean onDrag(View v, DragEvent event) {
//        switch (event.getAction()) {
//
//            case DragEvent.ACTION_DRAG_STARTED:
//                posX = v.getX() - event.getX();
//                posY = v.getY() - event.getY();
//                return true;
//
//            case DragEvent.ACTION_DRAG_ENTERED:
//                posX = v.getX() - event.getX();
//                posY = v.getY() - event.getY();
//                return true;
//
//            case DragEvent.ACTION_DROP:
//                v.setX(event.getX() + posX);
//                v.setY(event.getY() + posY);
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean onLongClick(View v) {
//
//        v.startDrag(null,  // the data to be dragged
//                null,  // the drag shadow builder
//                null,      // no need to use local data
//                0          // flags (not currently used, set to 0)
//        );
//
//        return true;
//    }




