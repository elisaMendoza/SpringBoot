package com.elisa.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elisa.lookify.models.Song;
import com.elisa.lookify.repositories.SongRepository;

@Service
public class SongService {
	//Agregando song al repositorio como una dependencia  
	private final SongRepository songRepo;
	    
	    public SongService(SongRepository songRepo) {
	        this.songRepo = songRepo;
	    }
	    //Devolver todas las canciones
	    public List<Song> allSongs() {
	    	return songRepo.findAll();
	    }
	    //Creando una canción.
	    public Song createSong(Song s) {
	        return songRepo.save(s);
	    }
	    //Buscar y obtener info de una canción
	    public Song findSong(Long id) {
	        Optional<Song> temp = songRepo.findById(id);
	        if(temp.isPresent()) {
	            return temp.get();
	        } else {
	            return null;
	        }  
	    }
	   //Buscar y obtener info de un artista el artista
	    public List<Song> findByArtist(String artist) {
	        return songRepo.findByArtist(artist);
	    }
	  //Borrar una cancion por su id
		public void deleteSong(Long id) {
	       songRepo.deleteById(id);
	       }
		//Actualizar una canción metodo1	
		public Song updateSong(Long id, String title, String artist, Integer rating) {
			Optional<Song> temp = songRepo.findById(id);
			 if(temp.isPresent()) {
				 Song s = temp.get();
				 s.setTitle(title);
				 s.setArtist(artist);
				 s.setRating(rating);
				 return songRepo.save(s);
		        } else {
		        	return null;
		        }
		}
		//Actualizar una cancion metodo2	
	    public Song updateBook(Song s) {
	    	return songRepo.save(s);
	    }
}
	  
