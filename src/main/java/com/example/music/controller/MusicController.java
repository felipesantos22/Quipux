package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.model.PlayList;
import com.example.music.service.MusicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/musics")
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    // Endpoint para criar música e associá-la à playlist
    @PostMapping("/{playlistId}/add")
    public ResponseEntity<Music> criarMusica(@PathVariable int playlistId, @RequestBody Music musica) {
        Music musicaCriada = musicService.createMusic(playlistId, musica.getTitulo(), musica.getArtista(), musica.getAlbum(), musica.getAno(), musica.getGenero());
        return ResponseEntity.ok(musicaCriada);
    }

    @GetMapping
    public List<Music> getAllPlaylists() {
        return musicService.getAllMusics();
    }
}
