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

    public PlayList createPlaylist(String nome, String descricao) {
        PlayList playList = new PlayList(nome, descricao, null);
        return playlistRepository.save(playList);
    }

    public List<PlayList> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<PlayList> getPlaylistById(int id) {
        return playlistRepository.findById(id);
    }

    public boolean deletePlaylist(int id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            return true;
        }
        return false;
    }
}