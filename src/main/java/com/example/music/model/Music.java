package com.example.music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String artista;
    private String album;
    private Integer ano;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "playlist_id", nullable = false)
    @JsonIgnore
    private PlayList playList;
    public Music() {
    }

    public Music(String titulo, String artista, String album, Integer ano, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.genero = genero;
    }

    public Music(String titulo, int id, String artista, String album, Integer ano, String genero, PlayList playList) {
        this.titulo = titulo;
        this.id = id;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.genero = genero;
        this.playList = playList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }
}