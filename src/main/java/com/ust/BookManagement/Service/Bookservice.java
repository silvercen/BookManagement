package com.ust.BookManagement.Service;

import com.ust.BookManagement.Model.Authordto;
import com.ust.BookManagement.Model.Book;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import com.ust.BookManagement.Repository.Bookrepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class Bookservice {

    @Autowired
    private Bookrepo bookrepo;

    public Book addBook(Book book)
    {
        book.setAuthor(getBookByAuthor(book.getBookauthorid()));
        return this.bookrepo.save(book);
    }

    public Book getABook(int id)
    {
        return this.bookrepo.findById(id).get();
    }

    public List<Book> getAllBooks()
    {
        return this.bookrepo.findAll();
    }

    public void deleteBook(int id)
    {
        this.bookrepo.deleteById(id);
    }

    @CircuitBreaker(name = "cirbook", fallbackMethod = "authorFallBack")
    public Authordto getBookByAuthor(String authorid)
    {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("http://author_management:5960/authors/"+authorid)
                .retrieve()
                .body(Authordto.class);
    }

    public Authordto authorFallBack()
    {
        return new Authordto("","");
    }
}
