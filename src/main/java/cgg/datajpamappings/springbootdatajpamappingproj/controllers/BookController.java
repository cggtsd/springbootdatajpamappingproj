package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.BookRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {
    
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
         return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
}
