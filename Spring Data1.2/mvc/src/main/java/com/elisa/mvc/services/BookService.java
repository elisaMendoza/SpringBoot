package com.elisa.mvc.services;
//SERVICE
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elisa.mvc.models.Book;
import com.elisa.mvc.repositories.BookRepository;

@Service
public class BookService {
	  //Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //Borrar un libro por su id
	public void deleteBook(Long id) {
       bookRepository.deleteById(id);
       }
	
	//Actualizar un libro metodo1	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		 if(optionalBook.isPresent()) {
			 Book b = optionalBook.get();
			 b.setTitle(title);
			 b.setDescription(desc);
			 b.setLanguage(lang);
			 b.setNumberOfPages(numOfPages);
			 return bookRepository.save(b);
	        } else {
	        	return null;
	        }
	}
	//Actualizar un libro metodo2	
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
  
}
