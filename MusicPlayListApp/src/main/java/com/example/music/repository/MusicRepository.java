package com.example.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.music.model.MusicPlaylist;



@Repository
public interface MusicRepository extends JpaRepository<MusicPlaylist, Long> {

}