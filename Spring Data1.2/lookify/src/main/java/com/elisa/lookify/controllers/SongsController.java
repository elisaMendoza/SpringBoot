package com.elisa.lookify.controllers;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.elisa.lookify.models.Song;
import com.elisa.lookify.services.SongService;


@Controller
public class SongsController {
private final SongService songService;
    
    public SongsController(SongService songService) {
        this.songService = songService;
    }
    
    @RequestMapping("/")
    public String index() {
        return "/welcome.jsp";
    }
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
       List<Song> songs = songService.allSongs();
       model.addAttribute("songs", songs);
        return "/dashboard.jsp";
    }
    
   @RequestMapping("/search")
    public String search(@RequestParam("artist") String artist) {
	   return "redirect:/search/"+artist;
   }
    @RequestMapping("/search/{artist}")
    public String showSongs(@PathVariable("artist") String artist, Model model) {
    	List<Song> songsArtist = songService.findByArtist(artist);
    	model.addAttribute("artist", artist);
    	model.addAttribute("songsArtist", songsArtist);
        return "/search.jsp";
    }
    @RequestMapping("/search/topTen")
    public String topTen(Model model) {
    	List<Song> songs = songService.allSongs();
        //Comparator<Song> byRating = Comparator.comparing(Song::getRating);
    	//Collections.sort(songs, byRating.reversed()); gracias a la documentacion de List y a https://www.techiedelight.com/sort-list-of-objects-using-comparator-java/
    	songs.sort((Comparator.comparing(Song::getRating)).reversed());
    	model.addAttribute("topSongs", songs);
        return "/topten.jsp";
    }

	@RequestMapping("/songs/{id}")
    public String showSong(@PathVariable("id") Long id, Model model) {
    	Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "/details.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/new.jsp";
    }
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) { 
		if (result.hasErrors()) {
    		 return "/new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
	}
    @RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }

}
