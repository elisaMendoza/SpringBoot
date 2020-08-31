package com.elisa.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elisa.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	 //Este método recupera todos los libros de la base de datos
    List<Song> findAll();
    //Este método encuentra una canción por su artista
    List<Song> findByArtist(String artist);
    //Este método cuenta cuántas canciones contienen cierta cadena en el título
    Long countByTitleContaining(String search);
    //Este método borra una canción que empieza con un título específico
    Long deleteByTitleStartingWith(String search);

}
