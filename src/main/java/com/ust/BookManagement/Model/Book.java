package com.ust.BookManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private Integer Bookid;
    private String Booktitle;
    private String Bookprice;
    private LocalDate Bookpublished;
    private String Bookimageurl;
    private String Bookauthorid;
    private Authordto author;
}
