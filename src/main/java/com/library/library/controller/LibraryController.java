package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.service.LibraryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class LibraryController {

    private final LibraryServiceImpl libraryService;

    @PostMapping("/library")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        libraryService.create(book);
        return book;
    }

    @GetMapping("/library")
    public ResponseEntity read() {
        final List<Book> books = libraryService.readAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity(books, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/library/{id}")
    public ResponseEntity read(@PathVariable(name = "id") UUID id){
        final Book book = libraryService.read(id);
        return book != null ? new ResponseEntity(book, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("library/{id}")
    public ResponseEntity update (@PathVariable(name = "id") UUID id, @RequestBody Book book){
        final boolean updated = libraryService.update(book, id);
        return updated ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("library/{id}")
    public ResponseEntity delete (@PathVariable(name = "id") UUID id){
        final boolean deleted = libraryService.delete(id);
        return deleted ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }
}
