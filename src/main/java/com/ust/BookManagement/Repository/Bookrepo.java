package com.ust.BookManagement.Repository;

import com.ust.BookManagement.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends MongoRepository<Book, Integer> {
}
