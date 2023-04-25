package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookService.addBooks(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("/books")
    public Book updateBook(@PathVariable("id") Long bookId, @RequestBody Book book) {

        return  bookService.updateBook(bookId,book);
    }
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
        return "Department deleted successfully";
    }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long bookId){
        return bookService.getBookById(bookId);
    }
    @GetMapping("/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable("genre") String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable("author") String author){
        return bookService.getBooksByAuthor(author);
    }


    @GetMapping("/books/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable("title") String title){
        return bookService.getBooksByTitle(title);
    }


}
