package com.speproject.majorproject.service.serviceImpl;

import com.speproject.majorproject.entity.Book;
import com.speproject.majorproject.repository.BookRepository;
import com.speproject.majorproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBooks(Book book){
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByGenre(String genre){
        return bookRepository.findAllByGenreIgnoreCase(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(String genre){
        return bookRepository.findAllByAuthorIgnoreCase(genre);
    }

    @Override
    public List<Book> getBooksByTitle(String genre){
        return bookRepository.findAllByTitleIgnoreCase(genre);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book bookDB = bookRepository.findById(bookId).get();
        if(Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())){
            bookDB.setTitle(book.getTitle());
        }
        if(Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())){
            bookDB.setAuthor(book.getAuthor());
        }
        if(Objects.nonNull(book.getImage()) && !"".equalsIgnoreCase(book.getImage())){
            bookDB.setImage(book.getTitle());
        }
        if(Objects.nonNull(book.getPrice())){
            bookDB.setPrice(book.getPrice());
        }
        if(Objects.nonNull(book.getDescription()) && !"".equalsIgnoreCase(book.getDescription())){
            bookDB.setDescription(book.getDescription());
        }
        if(Objects.nonNull(book.getAvailableForRent())){
            bookDB.setAvailableForRent(book.getAvailableForRent());
        }
        if(Objects.nonNull(book.getAvailableForSale())){
            bookDB.setAvailableForSale(book.getAvailableForSale());
        }
        return bookRepository.save(bookDB);

    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
