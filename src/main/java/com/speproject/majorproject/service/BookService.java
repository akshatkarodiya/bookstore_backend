package com.speproject.majorproject.service;

import com.speproject.majorproject.entity.Book;

import java.util.List;
import java.util.Optional;


public interface BookService {

    public Book addBooks(Book book);

    public List<Book> getAllBooks();

    public List<Book> getBooksByGenre(String genre);

    public List<Book> getBooksByAuthor(String genre);

    public List<Book> getBooksByTitle(String genre);

    public Book getBookById(Long bookId);



    public Book updateBook(Long bookId, Book book);

    public void deleteBookById(Long bookId);
}
