package com.library.library.service;

import com.library.library.model.Book;
import com.library.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BooksService{

    @Autowired
    private BookRepository bookRepository;

    public void create(Book book) {
        bookRepository.save(book);
    }

    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    public Book read(UUID id) {
        return bookRepository.getById(id);
    }

    public boolean update(Book book, UUID id) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    public boolean delete(UUID id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
