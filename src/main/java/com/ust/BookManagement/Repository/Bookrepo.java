package com.ust.BookManagement.Repository;

import com.ust.BookManagement.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepo extends JpaRepository<Book, Integer> {
}
