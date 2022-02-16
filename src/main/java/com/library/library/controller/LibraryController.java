package com.library.library.controller;

import com.library.library.model.Book;
import com.library.library.service.LibraryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
public class LibraryController {

    @Autowired
    private final LibraryService libraryService;

    @PostMapping("/library")
    public ResponseEntity<?> create(@RequestBody Book book) {
        libraryService.create(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/library")
    public ResponseEntity read() {
        final List<Book> books = libraryService.readAll();
        return books != null && !books.isEmpty()
                ? new ResponseEntity(books, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/library/{id}")
    public ResponseEntity read(@PathVariable(name = "id") int id){
        final Book book = libraryService.read(id);
        return book != null ? new ResponseEntity(book, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("library/{id}")
    public ResponseEntity update (@PathVariable(name = "id") int id, @RequestBody Book book){
        final boolean updated = libraryService.update(book, id);
        return updated ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("library/{id}")
    public ResponseEntity delete (@PathVariable(name = "id")int id){
        final boolean deleted = libraryService.delete(id);
        return deleted ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }
}
