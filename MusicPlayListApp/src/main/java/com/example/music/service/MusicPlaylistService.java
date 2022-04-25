package com.example.music.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.model.MusicPlaylist;
import com.example.music.repository.MusicRepository;
import java.util.List;

@Service
public class MusicPlaylistService {

        @Autowired
        MusicRepository  musRepository; 
        
        
        
     // CREATE 
        public MusicPlaylist createMusic(MusicPlaylist playlist) {
            return musRepository.save(playlist);
        }

        // READ
        public List<MusicPlaylist> getMusicPlaylist() {
            return musRepository.findAll();
        }

        // DELETE
        public void deleteMusic(Long Id) {
            musRepository.deleteById(Id);
        }
        
        //Patch
        public MusicPlaylist updatetoMusic(Long id, MusicPlaylist musicDetails) {
        	MusicPlaylist mus = musRepository.findById(id).get();
        	mus.setName(musicDetails.getName());
            mus.setGenre(musicDetails.getGenre());
            mus.setArtist(musicDetails.getArtist());
            mus.setDuration(musicDetails.getDuration());
            return musRepository.save(mus);  
        }
        
     // UPDATE
        public MusicPlaylist updateMusicPlaylist(Long Id, MusicPlaylist musicDetails ) {
                MusicPlaylist mus = musRepository.findById(Id).get();
				mus.setName(musicDetails.getName());
                mus.setGenre(musicDetails.getGenre());
                mus.setArtist(musicDetails.getArtist());
                mus.setDuration(musicDetails.getDuration());
                return musRepository.save(mus);                                
        }

}
