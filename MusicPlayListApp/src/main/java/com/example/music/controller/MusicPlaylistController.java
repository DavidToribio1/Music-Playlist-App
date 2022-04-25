package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.model.*;
import com.example.music.service.*;


@RestController
@RequestMapping("/api")
public class MusicPlaylistController {
	@Autowired
	MusicPlaylistService musService;
	
	@PostMapping("/playlist/track")
	public MusicPlaylist createMusicPlaylist(@RequestBody MusicPlaylist playlist) {
		return musService.createMusic(playlist);
	}

	@GetMapping("/playlist/track")
	public List<MusicPlaylist> readMusicPlaylist() {
	    return musService.getMusicPlaylist();
	}
	@RequestMapping(value="/playlist/track/{Id}", method=RequestMethod.PATCH)
	public MusicPlaylist fixMusic(@PathVariable(value = "Id")Long id, @RequestBody MusicPlaylist musicDetails) {
		return musService.updatetoMusic(id, musicDetails);
	}
	
	@RequestMapping(value="/playlist/track/{Id}", method=RequestMethod.PUT)
	public MusicPlaylist updateMusicPlaylist(@PathVariable(value = "Id") Long id, @RequestBody MusicPlaylist musicDetails) {
	    return musService.updateMusicPlaylist(id, musicDetails);
	}
	
	@RequestMapping(value="/playlist/track/{Id}", method=RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "Id") Long id) {
	    musService.deleteMusic(id);
	}
}