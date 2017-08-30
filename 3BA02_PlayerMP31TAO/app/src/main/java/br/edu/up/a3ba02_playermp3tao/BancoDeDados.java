package br.edu.up.a3ba02_playermp3tao;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

  public List<Musica> carregarListaDeMusicas(){

    List<Musica> lista = new ArrayList<>();

    Musica m1 = new Musica();
    m1.setId(1);
    m1.setBanda("Anitta");
    m1.setNome("Bang");
    m1.setCapa(R.drawable.anitta);
    m1.setMp3(R.raw.anitta_bang);

    Musica m2 = new Musica();
    m2.setId(2);
    m2.setBanda("Jota Quest");
    m2.setNome("Na moral");
    m2.setCapa(R.drawable.jota_quest);
    m2.setMp3(R.raw.jota_quest_na_moral);

    Musica m3 = new Musica();
    m3.setId(3);
    m3.setBanda("Pink Floyd");
    m3.setNome("Another Brick in the Wall");
    m3.setCapa(R.drawable.pink_floyd);
    m3.setMp3(R.raw.pink_floyd_another_brick_in_the_wall_p2);

    Musica m4 = new Musica();
    m4.setId(4);
    m4.setBanda("Sambô");
    m4.setNome("Sunday bloody sunday");
    m4.setCapa(R.drawable.sambo);
    m4.setMp3(R.raw.sambo_sunday_bloody_sunday);

    Musica m5 = new Musica();
    m5.setId(5);
    m5.setBanda("Talking Heads");
    m5.setNome("Psycho Killer");
    m5.setCapa(R.drawable.talking_heads);
    m5.setMp3(R.raw.talking_heads_psycho_killer);

    Musica m6 = new Musica();
    m6.setId(6);
    m6.setBanda("The Doors");
    m6.setNome("Light my fire");
    m6.setCapa(R.drawable.the_doors);
    m6.setMp3(R.raw.the_doors_light_my_fire);

    Musica m7 = new Musica();
    m7.setId(7);
    m7.setBanda("Zeca Baleiro");
    m7.setNome("Disritimia");
    m7.setCapa(R.drawable.zeca_baleiro);
    m7.setMp3(R.raw.zeca_baleiro_disritmia);

    lista.add(m1);
    lista.add(m2);
    lista.add(m3);
    lista.add(m4);
    lista.add(m5);
    lista.add(m6);
    lista.add(m7);

    return lista;
  }



}
