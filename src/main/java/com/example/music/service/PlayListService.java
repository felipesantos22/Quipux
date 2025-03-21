package com.example.music.service;

import com.example.music.model.PlayList;
import com.example.music.repository.PlayListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayListService {

    private final PlayListRepository playlistRepository;

    public PlayListService(PlayListRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public PlayList createPlaylist(PlayList playlist) {
        return playlistRepository.save(playlist);
    }

    public List<PlayList> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<PlayList> getPlaylistById(Long id) {
        return playlistRepository.findById(id);
    }

    public boolean deletePlaylist(Long id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            return true;
        }
        return false;
    }
}