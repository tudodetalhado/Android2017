package br.edu.up.a3ba02_playermp31te;

public class Musica {

    private int id;
    private int mp3;
    private int capa;
    private String nome;
    private String artista;

    public int getId() { //pegar o valor do id;
        return id;
    }

    public void setId(int id) { //alterar o valor do id;
        this.id = id;
    }


    public int getMp3() {
        return mp3;
    }

    public void setMp3(int mp3) {
        this.mp3 = mp3;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}
