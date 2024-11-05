package com.ust.BookManagement.Controller;

import com.ust.BookManagement.Model.Book;
import com.ust.BookManagement.Repository.Bookrepo;
import com.ust.BookManagement.Service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookapi/")
public class Bookcontroller {

    @Autowired
    private Bookservice bookservice;

    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return bookservice.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getABook(@PathVariable int id)
    {
        return bookservice.getABook(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        return bookservice.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id)
    {
        bookservice.deleteBook(id);
    }
}
