package com.example.music.controller;

import com.example.music.DTO.ApiResponse;
import com.example.music.model.PlayList;
import com.example.music.service.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/playlists")
public class PlayListController {
    private final PlayListService playlistService;

    public PlayListController(PlayListService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<PlayList> createPlaylist(@RequestBody PlayList playlist) {
        PlayList savedPlaylist = playlistService.createPlaylist(playlist.getNome(), playlist.getDescricao());
        return ResponseEntity.ok(savedPlaylist);
    }

    @GetMapping
    public List<PlayList> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayList> getPlaylistById(@PathVariable int id) {
        Optional<PlayList> playlist = playlistService.getPlaylistById(id);
        return playlist.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePlaylist(@PathVariable int id) {
        if (playlistService.deletePlaylist(id)) {
            return ResponseEntity.ok(new ApiResponse("Playlist deletada com sucesso!", 200));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Playlist não encontrada.", 404));
        }
    }
}
