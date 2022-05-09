package com.example.music;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.music.model.MusicPlaylist;
import com.example.music.repository.MusicRepository;

import antlr.collections.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MusicPlayListAppApplicationTests {

	@Autowired
	MusicRepository musRepo;

	@Test
	@Order(1)
	public void testCreate() {
		
		MusicPlaylist mp = new MusicPlaylist();
		mp.setId(1L);
		mp.setName("In the air tonight");
		mp.setArtist("phil collins");
		mp.setDuration(536);
		mp.setGenre("Rock");
		musRepo.save(mp);
		assertNotNull(musRepo.findById(1L).get());
	}
		
		@Test
		@Order(2)
		public void testReadAll() {
			List<MusicPlaylist>list=musRepo.findAll();
			assertThat(list).size().isGreaterThan(0);
		}
		
		@Test
		@Order(3)
		public void testSingleMusic() {
		MusicPlaylist music = musRepo.findById(1L).get();
		assertEquals("TNT",music.getName());
		}
		
		@Test
		@Order(4)
		public void testUpdate() {
			MusicPlaylist m= musRepo.findById(1L).get();
			m.setName("In the air tonight");
			musRepo.save(m);
			assertNotEquals("TNT", musRepo.findById(1L).get().getName());
		}
		
		@Test
		@Order(5)
		public void testDelete() {
			musRepo.deleteById(1L);
			assertThat(musRepo.existsById(1L)).isFalse();
			
		}

		


}
