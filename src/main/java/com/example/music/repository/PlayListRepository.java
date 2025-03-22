package com.example.music.repository;

import com.example.music.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<PlayList, Integer> {
}
