package br.edu.up.a3ba02_playermp3tao;

public class Musica {

    private int id;
    private String nome;
    private String banda;
    private int mp3;
    private int capa;


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getMp3() {
        return mp3;
    }

    public void setMp3(int MP3) {
        this.mp3 = MP3;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }
}
