package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.model.PlayList;
import com.example.music.repository.MusicRepository;
import com.example.music.repository.PlayListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    private final MusicRepository musicRepository;
    private PlayListRepository playListRepository;

    public MusicService(PlayListRepository playListRepository, MusicRepository musicRepository) {
        this.playListRepository = playListRepository;
        this.musicRepository = musicRepository;
    }

    public Music createMusic(int playlistId, String titulo, String artista, String album, Integer ano, String genero) {
        Optional<PlayList> playListOpt = playListRepository.findById(playlistId);

        if (playListOpt.isEmpty()) {
            throw new RuntimeException("Playlist não encontrada");
        }

        PlayList playList = playListOpt.get();

        // Criação da música e associação com a playlist
        Music music = new Music(titulo, artista, album, ano, genero);
        music.setPlayList(playList);

        // Salva a música no banco de dados
        return musicRepository.save(music);
    }

    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }
}
