package com.ust.BookManagement.Controller;

import com.ust.BookManagement.Model.Book;
import com.ust.BookManagement.Repository.Bookrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookapi/")
public class Bookcontroller {

    @Autowired
    private Bookrepo bookrepo;

    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return this.bookrepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getABook(@PathVariable int id)
    {
        return this.bookrepo.findById(id).get();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        return this.bookrepo.save(book);
    }
}
