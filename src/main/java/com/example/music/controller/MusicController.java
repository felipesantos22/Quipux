package com.example.music.controller;

import com.example.music.model.Music;
import com.example.music.model.PlayList;
import com.example.music.service.MusicService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> criarMusica(@PathVariable int playlistId, @RequestBody Music musica) {
        try {
            Music musicaCriada = musicService.createMusic(playlistId, musica.getTitulo(), musica.getArtista(), musica.getAlbum(), musica.getAno(), musica.getGenero());
            return ResponseEntity.ok(musicaCriada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("PlayList not found.");
        }
    }


    @GetMapping
    public List<Music> getAllPlaylists() {
        return musicService.getAllMusics();
    }

    @DeleteMapping("/{idMusic}")
    public ResponseEntity<String> deleteMusic(@PathVariable int idMusic) {
        musicService.deleteMusic(idMusic);
        return ResponseEntity.ok("Música deletada com sucesso.");
    }

}
