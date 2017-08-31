package br.edu.up.a3ba02_playermp32te;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

  public List<Musica> getListaDeMusicas(){

    List<Musica> listaDeMusicas = new ArrayList<>();

    Musica m1 = new Musica();
    m1.setId(1);
    m1.setArtista("Anitta");
    m1.setNome("Bang");
    m1.setCapa(R.drawable.anitta);
    m1.setMp3(R.raw.anitta_bang);

    Musica m2 = new Musica();
    m2.setId(2);
    m2.setArtista("Jota Quest");
    m2.setNome("Na moral");
    m2.setCapa(R.drawable.jota_quest);
    m2.setMp3(R.raw.jota_quest_na_moral);

    Musica m3 = new Musica();
    m3.setId(3);
    m3.setArtista("Pink Floyd");
    m3.setNome("Another Brick in the Wall");
    m3.setCapa(R.drawable.pink_floyd);
    m3.setMp3(R.raw.pink_floyd_another_brick_in_the_wall_p2);

    Musica m4 = new Musica();
    m4.setId(4);
    m4.setArtista("Sambô");
    m4.setNome("Sunday bloody sunday");
    m4.setCapa(R.drawable.sambo);
    m4.setMp3(R.raw.sambo_sunday_bloody_sunday);

    Musica m5 = new Musica();
    m5.setId(5);
    m5.setArtista("Talking Heads");
    m5.setNome("Psycho Killer");
    m5.setCapa(R.drawable.talking_heads);
    m5.setMp3(R.raw.talking_heads_psycho_killer);

    Musica m6 = new Musica();
    m6.setId(6);
    m6.setArtista("The Doors");
    m6.setNome("Light my fire");
    m6.setCapa(R.drawable.the_doors);
    m6.setMp3(R.raw.the_doors_light_my_fire);

    Musica m7 = new Musica();
    m7.setId(7);
    m7.setArtista("Zeca Baleiro");
    m7.setNome("Disritimia");
    m7.setCapa(R.drawable.zeca_baleiro);
    m7.setMp3(R.raw.zeca_baleiro_disritmia);

    listaDeMusicas.add(m1);
    listaDeMusicas.add(m2);
    listaDeMusicas.add(m3);
    listaDeMusicas.add(m4);
    listaDeMusicas.add(m5);
    listaDeMusicas.add(m6);
    listaDeMusicas.add(m7);

//    for(int i = 8; i < 100; i++){
//      Musica musica = new Musica();
//      musica.setId(i);
//      musica.setNome("Musica " + i);
//      listaDeMusicas.add(musica);
//    }


    return  listaDeMusicas;
  }
}
