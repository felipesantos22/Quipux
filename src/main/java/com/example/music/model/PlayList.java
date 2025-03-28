package com.example.music.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlists")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "playList", cascade = CascadeType.ALL)
    private List<Music> musicas;

    public PlayList() {}

    public PlayList(String nome, String descricao, List<Music> musicas) {
        this.nome = nome;
        this.descricao = descricao;
        this.musicas = musicas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Music> getMusicas() { return musicas; }
    public void setMusicas(List<Music> musicas) { this.musicas = musicas; }
}
